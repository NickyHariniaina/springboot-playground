package com.application.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService userService;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userService.getUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
  }

  public UserService getUserService() {
    return userService;
  }

}
