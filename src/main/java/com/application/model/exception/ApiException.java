package com.application.model.exception;

import lombok.Getter;

/**
 * ApiException
 */
public class ApiException extends RuntimeException {

  @Getter
  private final ExceptionType exceptionType;

  public ApiException(ExceptionType type, String message) {
    super(message);
    this.exceptionType = type;
  }

  public ApiException(ExceptionType type, Exception source) {
    super(source);
    this.exceptionType = type;
  }

  public enum ExceptionType {
    SERVER_EXCEPTION,
    CLIENT_EXCEPTION,
  }
}

