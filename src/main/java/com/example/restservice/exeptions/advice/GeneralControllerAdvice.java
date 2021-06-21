package com.example.restservice.exeptions.advice;

import com.example.restservice.exeptions.GeneralExeption;
import com.example.restservice.exeptions.GeneralResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {
    @ExceptionHandler(GeneralExeption.class)
    public ResponseEntity<GeneralResult> handle(GeneralExeption ex) {
        return new ResponseEntity<>(ex.getGeneralResult(), HttpStatus.BAD_REQUEST);
    }
}
