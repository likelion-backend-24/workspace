package org.example.restexam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@ControllerAdvice  --  html 기반으로 만들어진 view 조금더 맞게 (Controller, RestController)

@RestControllerAdvice  //Rest api 에 특화된 advice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Runtime Error : "+ ex.getMessage() );
    }
}
