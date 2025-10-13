package com.application.model.exception;

/**
 * BadRequestException
 */
public class BadRequestException extends ApiException{
  public BadRequestException(String message) {
    super(ExceptionType.CLIENT_EXCEPTION, message);
    System.out.println(message);
  }

}
