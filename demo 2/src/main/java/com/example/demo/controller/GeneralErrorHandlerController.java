package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorResponse;

@RestControllerAdvice
public class GeneralErrorHandlerController {

    @ExceptionHandler(Exception.class)

    public ResponseEntity<?> generalErrorHandler(Exception e){
        ErrorResponse error = new ErrorResponse();
        error.setError("error general de spring");
        error.setDetail(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
