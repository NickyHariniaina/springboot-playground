package com.application.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

  @Value("${app.secret-key}")
  private String secretKey;

  @Value("${app.expiration-time}")
  private long expirationTime;

  public String generateToken(UserDetails userDetails) {
    return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
        .signWith(getSignInKey(), SignatureAlgorithm.HS512)
        .compact();
  }

  private Key getSignInKey() {
    return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
  }

  public String extractUsername(String jwt) {
    return extractClaim(jwt, Claims::getSubject);
  }

  public boolean validateToken(String jwt, UserDetails userDetails) {
    final String username = extractUsername(jwt);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
  }

  private boolean isTokenExpired(String jwt) {
    return extractClaim(jwt, Claims::getExpiration).before(new Date());
  }

  public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(jwt);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String jwt) {
    return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(jwt).getBody();
  }
}
