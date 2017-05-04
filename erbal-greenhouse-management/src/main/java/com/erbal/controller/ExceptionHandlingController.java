package com.erbal.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {

  @ResponseStatus(
          value = HttpStatus.CONFLICT,
          reason = "Data integrity violation"
  )
  @ExceptionHandler(DataIntegrityViolationException.class)  //409
  public void conflict() {}

  @ResponseStatus(
          value = HttpStatus.BAD_REQUEST,
          reason = "Bad Request"
  )
  @ExceptionHandler(IllegalArgumentException.class)   //400
  public void badRequest() {}

  @ResponseStatus(
          value = HttpStatus.NOT_FOUND,
          reason = "Document Not Found"
  )
  @ExceptionHandler(EntityNotFoundException.class)    //404
  public void notFound() {}

  @ResponseStatus(
          value = HttpStatus.INTERNAL_SERVER_ERROR,
          reason = "Server fault"
  )
  @ExceptionHandler(Exception.class)
  public void exception(Exception e) {
    //logging
    e.printStackTrace();
  }
}