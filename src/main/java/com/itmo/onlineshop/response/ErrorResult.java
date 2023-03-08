package com.itmo.onlineshop.response;

import com.itmo.onlineshop.exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResult implements Response {

  private ErrorCode code;
  private String description;
}
