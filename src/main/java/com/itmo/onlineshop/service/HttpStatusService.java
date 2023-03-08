package com.itmo.onlineshop.service;

import com.itmo.onlineshop.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public interface HttpStatusService {

  HttpStatus errorCode2HttpStatus(ErrorCode errorCode);

  ErrorCode httpStatus2ErrorCode(HttpStatusCode status);
}
