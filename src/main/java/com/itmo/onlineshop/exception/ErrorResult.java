package com.itmo.onlineshop.exception;

import com.itmo.onlineshop.Response;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResult implements Response {

  private ErrorCode code;
  private String description;
}
