package com.application.endpoint.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest
 */
@RestController
public class Rest {

  @GetMapping
  public String ping() {
    return "pong";
  }
}
