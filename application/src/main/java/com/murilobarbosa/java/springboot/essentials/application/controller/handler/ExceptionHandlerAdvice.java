package com.murilobarbosa.java.springboot.essentials.application.controller.handler;

import com.murilobarbosa.java.springboot.essentials.core.exception.base.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public ErrorResponse handleConflictException(ConflictException exception) {
        return ErrorResponse.builder().message(exception.getMessage()).build();
    }
}
