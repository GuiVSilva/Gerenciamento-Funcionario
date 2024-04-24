package com.example.ac2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ac2.exception.ApiErros;
import com.example.ac2.exception.RegraNegocioException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(RegraNegocioException.class)
    public ApiErros handleRegraNegocioException(RegraNegocioException ex){
        return new ApiErros(ex.getMessage());
    }
}
