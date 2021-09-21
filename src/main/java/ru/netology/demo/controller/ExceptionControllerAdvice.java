package ru.netology.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    private static final int RUNTIME_EXCEPTION_ID = 10;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerCardNotFound(RuntimeException e) {
        String resp = e.getMessage();
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
