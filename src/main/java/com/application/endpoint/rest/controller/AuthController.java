package com.application.endpoint.rest.controller;

import com.application.model.User;
import com.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginBody body) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        new UsernamePasswordAuthenticationToken(body.username(), body.password());
    authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    return ResponseEntity.ok("Login Successful");
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody LoginBody body) {
    if (userService.getUserByUsername(body.username()).isPresent()) {
      return ResponseEntity.badRequest().body("Username already exists");
    }

    User user =
        User.builder()
            .username(body.username())
            .password(passwordEncoder.encode(body.password()))
            .role("ROLE_USER")
            .status(User.Status.ENABLED)
            .build();

    userService.createUser(user);
    return ResponseEntity.ok("Register Successful");
  }

  private static record LoginBody(String username, String password) {}
}
