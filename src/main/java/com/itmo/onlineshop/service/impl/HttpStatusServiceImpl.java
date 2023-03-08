package com.itmo.onlineshop.service.impl;

import com.itmo.onlineshop.exception.ErrorCode;
import com.itmo.onlineshop.service.HttpStatusService;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public class HttpStatusServiceImpl implements HttpStatusService {

  private static final HttpStatus defaultHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  private static final ErrorCode defaultErrorCodeStatus = ErrorCode.INTERNAL_ERROR;

  private static final List<ErrorCode> unauthorized = Arrays.asList(ErrorCode.AUTH_ERROR);
  private static final List<ErrorCode> badRequest = Arrays.asList(ErrorCode.VALIDATION_ERROR, ErrorCode.BAD_REQUEST);
  private static final List<ErrorCode> forbidden = Arrays.asList(ErrorCode.FORBIDDEN);
  private static final List<ErrorCode> notFound = Arrays.asList(ErrorCode.NOT_FOUND);
  private static final List<ErrorCode> internalError = Arrays.asList(ErrorCode.INTERNAL_ERROR);

  @Override
  public HttpStatus errorCode2HttpStatus(ErrorCode errorCode) {
    if (unauthorized.contains(errorCode)) {
      return HttpStatus.UNAUTHORIZED;
    }

    if (badRequest.contains(errorCode)) {
      return HttpStatus.BAD_REQUEST;
    }

    if (forbidden.contains(errorCode)) {
      return HttpStatus.FORBIDDEN;
    }

    if (notFound.contains(errorCode)) {
      return HttpStatus.NOT_FOUND;
    }

    if (internalError.contains(errorCode)) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return defaultHttpStatus;
  }

  @Override
  public ErrorCode httpStatus2ErrorCode(HttpStatusCode status) {
    if (status.is4xxClientError() && status instanceof HttpStatus) {

      if (status.equals(HttpStatus.BAD_REQUEST)) {
        return ErrorCode.BAD_REQUEST;
      }

      if (status.equals(HttpStatus.UNAUTHORIZED)) {
        return ErrorCode.AUTH_ERROR;
      }

      if (status.equals(HttpStatus.FORBIDDEN)) {
        return ErrorCode.FORBIDDEN;
      }

      if (status.equals(HttpStatus.NOT_FOUND)) {
        return ErrorCode.NOT_FOUND;
      }

      return ErrorCode.BAD_REQUEST;
    }

    return defaultErrorCodeStatus;
  }
}
