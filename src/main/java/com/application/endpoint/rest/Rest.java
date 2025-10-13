package com.application.endpoint.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.exception.BadRequestException;
import com.application.model.exception.NotFoundException;

/**
 * Rest
 */
@RestController
public class Rest {

  // This code is only use for test.
  @GetMapping
  public ResponseEntity<Exception> health() {
    ExceptionConverter e = new ExceptionConverter();
    return e.handleNotFound(new NotFoundException("Erreur"));
  }
}
