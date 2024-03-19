package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomBaseException.class)
    public ResponseEntity<SimpleResponse> handProductNotFoundException(CustomBaseException customBaseException) {
        return ResponseEntity.status(customBaseException.getStatus()).body(customBaseException.getSimpleResponse());
    }
}
