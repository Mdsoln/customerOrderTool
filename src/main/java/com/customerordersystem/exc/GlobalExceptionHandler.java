package com.customerordersystem.exc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {GlobalException.class})
    public ResponseEntity<Object> handleExceptions(
            GlobalException globalException
    ){
        GlobalExceptionFields globalExceptionFields = new GlobalExceptionFields(
                globalException.getMessage(),
                globalException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(globalExceptionFields,HttpStatus.BAD_REQUEST);
    }

}
