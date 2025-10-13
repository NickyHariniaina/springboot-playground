package com.application.endpoint.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.model.exception.AccessDeniedException;
import com.application.model.exception.BadRequestException;
import com.application.model.exception.NotFoundException;


/**
 * ExceptionConverter
 */
@RestControllerAdvice
public class ExceptionConverter {

  @ExceptionHandler(value = {BadRequestException.class})
  public ResponseEntity<Exception> handleBadRequest(BadRequestException err) {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = {NotFoundException.class})
  public ResponseEntity<Exception> handleNotFound(NotFoundException err) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {AccessDeniedException.class})
  public ResponseEntity<Exception> handleAccessDenied(AccessDeniedException err) {
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
