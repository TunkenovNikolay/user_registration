package com.tunkenov.user_registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MyEntityNotFoundException.class, EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFoundEx(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError("entity not found ex", ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
