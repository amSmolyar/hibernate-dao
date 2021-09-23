package ru.netology.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerE(Exception e) {
        String resp = e.getMessage();
        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRE(RuntimeException e) {
        String resp = e.getMessage();
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}
