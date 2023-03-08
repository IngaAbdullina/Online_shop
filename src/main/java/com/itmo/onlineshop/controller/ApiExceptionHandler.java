package com.itmo.onlineshop.controller;

import static java.util.stream.Collectors.joining;

import com.itmo.onlineshop.exception.ApiException;
import com.itmo.onlineshop.exception.ErrorCode;
import com.itmo.onlineshop.response.ErrorResult;
import com.itmo.onlineshop.response.Response;
import com.itmo.onlineshop.service.HttpStatusService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private final HttpStatusService httpStatusService;

  public ApiExceptionHandler(HttpStatusService httpStatusService) {
    this.httpStatusService = httpStatusService;
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
      HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    String description = String.format(
        "Переменная %s является обязательной и не может быть пустой", ex.getVariableName());
    return ResponseEntity.badRequest().body(
        ErrorResult.builder()
            .code(ErrorCode.BAD_REQUEST)
            .description(description)
            .build());
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestParameter(
      MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    String description = String.format("Параметр %s является обязательным и не может быть пустым",
        ex.getParameterName());
    return ResponseEntity.badRequest().body(
        ErrorResult.builder()
            .code(ErrorCode.BAD_REQUEST)
            .description(description)
            .build());
  }

  @Override
  protected ResponseEntity<Object> handleMissingServletRequestPart(
      MissingServletRequestPartException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleServletRequestBindingException(
      ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    BindingResult bindingResult = ex.getBindingResult();

    String errors = bindingResult
        .getFieldErrors()
        .stream()
        .map(e -> e.getField() + ' ' + e.getDefaultMessage())
        .collect(joining("," + System.lineSeparator() + " "));

    writeLogWithRequestErrorInfo(ex, request);
    return ResponseEntity.badRequest().body(
        ErrorResult.builder()
            .code(ErrorCode.BAD_REQUEST)
            .description(errors)
            .build());
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
      AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatusCode status,
      WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleErrorResponseException(ErrorResponseException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return handleExceptionInternal(ex, null, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
      HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
    writeLogWithRequestErrorInfo(ex, request);
    return ResponseEntity.status(statusCode).body(
        ErrorResult.builder()
            .code(httpStatusService.httpStatus2ErrorCode(statusCode))
            .description(ex.getMessage())
            .build());
  }

  @ExceptionHandler
  public ResponseEntity<Response> handleApiException(ApiException ex) {
    ErrorResult errorResult = ex.getErrorResult();
    ErrorCode errorCode = errorResult.getCode();
    log.error(errorResult.getDescription());
    return ResponseEntity.status(httpStatusService.errorCode2HttpStatus(errorCode)).body(
        ex.getErrorResult());
  }

  @ExceptionHandler
  public ResponseEntity<Response> handleConstraintViolationException(
      ConstraintViolationException ex, WebRequest request) {
    String errors = ex.getConstraintViolations()
        .stream()
        .map(v -> v.getPropertyPath().toString() + ' ' + v.getMessage())
        .collect(joining("," + System.lineSeparator() + " "));

    writeLogWithRequestErrorInfo(ex, request);
    return ResponseEntity.badRequest().body(
        ErrorResult.builder()
            .code(ErrorCode.BAD_REQUEST)
            .description(errors)
            .build());
  }

  private void writeLogWithRequestErrorInfo(Exception ex, WebRequest request) {
    HttpServletRequest httpServletRequest = ((ServletWebRequest) request).getRequest();
    String url = httpServletRequest.getRequestURL().toString();
    String method = httpServletRequest.getMethod();
    String message = ex.getMessage();

    log.error(String.format(
        "Error while requesting %s %s. Cause: %s.", method, url, message));
  }
}
