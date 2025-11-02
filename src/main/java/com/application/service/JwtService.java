
package com.application.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

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
}
