package com.application.model.exception;

/** AccessDeniedException */
public class AccessDeniedException extends ApiException {

  public AccessDeniedException() {
    super(ExceptionType.CLIENT_EXCEPTION, "Access denied.");
  }
}
