package com.erbal.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    //409
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
    }

    // 400
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badRequest() {
    }

    // 404
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Document not found")
    @ExceptionHandler(EntityNotFoundException.class)
    public void notFound() {
    }

    // 500
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Server fault")
    @ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        e.printStackTrace();
        //log.error(e.getMessage(), e);
    }
}