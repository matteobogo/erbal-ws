package com.erbal.controller;

import com.erbal.exception.AlreadyPairedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @ResponseStatus(
          value = HttpStatus.BAD_REQUEST,
          reason = "Node already paired"
  )
  @ExceptionHandler(AlreadyPairedException.class)
  public void alreadyPairedException() {}

  @ResponseStatus(
          value = HttpStatus.BAD_REQUEST,
          reason = "Data format is wrong"
  )
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public void dataFormatException() {}






  @ResponseStatus(
          value = HttpStatus.CONFLICT,
          reason = "Data integrity violation"
  )
  @ExceptionHandler(DataIntegrityViolationException.class)  //409
  public void conflict() {}
//  @ResponseStatus(
//          value = HttpStatus.BAD_REQUEST,
//          reason = "Bad Request"
//  )
//  @ExceptionHandler(IllegalArgumentException.class)   //400
//  public void badRequest() {}

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

    log.error(e.toString());
  }
}