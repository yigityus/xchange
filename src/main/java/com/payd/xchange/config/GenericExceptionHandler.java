package com.payd.xchange.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handle(IllegalArgumentException exception) {
        Error error = new Error(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.of(Optional.of(error));
    }
    record Error(String message, HttpStatus status){}
}
