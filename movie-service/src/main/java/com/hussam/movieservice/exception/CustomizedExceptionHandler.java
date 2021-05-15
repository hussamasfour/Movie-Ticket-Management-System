package com.hussam.movieservice.exception;


import org.apache.commons.lang3.exception.ExceptionUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String TRACE = "trace";

    @Value("${reflectoring.trace:false}")
    private boolean printStackTrace;

//    @Override
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
//        List<FieldError> s = ex.getBindingResult().getFieldErrors();
//        ExceptionResponse errorResponse = new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Validation error", new Date());
//
//
////        return ResponseEntity.unprocessableEntity().body(errorResponse);
//    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleItemNotFoundException(NoSuchElementFoundException ex , WebRequest request){
       String message =  ex.getLocalizedMessage();
       ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(),"NOT FOUND", message);
        return new ResponseEntity<>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request){
//        return buildErrorResponse(exception, "Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR, request);
//
//    }

}
