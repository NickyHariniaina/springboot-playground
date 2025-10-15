package com.application.model.exception;

/** NotFoundException */
public class NotFoundException extends ApiException {

  public NotFoundException(String message) {
    super(ExceptionType.CLIENT_EXCEPTION, message);
  }
}
