package com.itmo.onlineshop.exception;

import com.itmo.onlineshop.response.ErrorResult;
import lombok.Getter;

@Getter
public class ApiException extends Exception {

  private final ErrorResult errorResult;

  public ApiException(ErrorCode errorCode, String message) {
    super(message);
    errorResult = ErrorResult.builder()
        .code(errorCode)
        .description(message)
        .build();
  }
}
