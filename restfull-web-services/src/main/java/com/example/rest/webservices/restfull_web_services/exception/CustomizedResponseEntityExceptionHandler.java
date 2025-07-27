package com.example.rest.webservices.restfull_web_services.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDrtails> handleAllException(Exception ex, WebRequest request) {
        ErrorDrtails errorDetails = new ErrorDrtails(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDrtails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDrtails> handleUserNotFoundException(Exception ex, WebRequest request) {
        ErrorDrtails errorDetails = new ErrorDrtails(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDrtails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDrtails errorDetails = new ErrorDrtails("Total Errors: "+ex.getErrorCount() + "First Error: " + ex.getFieldError().getDefaultMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
