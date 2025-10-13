package com.application.model.exception;

/** AccessDeniedException */
public class AccessDeniedException extends ApiException {

  public AccessDeniedException(String message) {
    super(ExceptionType.CLIENT_EXCEPTION, message);
  }
}
