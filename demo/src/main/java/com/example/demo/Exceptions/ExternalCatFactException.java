package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class ExternalCatFactException extends CustomBaseException{
    public ExternalCatFactException(HttpStatus status, SimpleResponse simpleResponse) {
        super(status, simpleResponse);
    }
}
