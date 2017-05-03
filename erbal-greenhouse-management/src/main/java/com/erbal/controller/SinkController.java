package com.erbal.controller;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.erbal.service.CrudService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/sinks")
public class SinkController extends ExceptionHandlingController {

  private CrudService sinkService;

  @Autowired
  public SinkController(CrudService sinkService) { this.sinkService = sinkService; }

  @RequestMapping(
          value = "/add",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
  public MessageDTO<Sink> add(
          @RequestBody @Valid Sink sink) {

    return sinkService.add(sink);
  }

  @RequestMapping(
          value = "/update",
          method = RequestMethod.PUT,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Sink> update(
          @RequestBody @Valid Sink sink) {

    return sinkService.update(sink);
  }

  @RequestMapping(
          value = "/{serialId}",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Sink> findBySerialId(
          @PathVariable("serialId") String serialId) {

    return sinkService.getEntityBySerialId(serialId);
  }

  @RequestMapping(
          value = "/",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Sink> findAll() {

    return sinkService.getAll();
  }

  @RequestMapping(
          value = "/delete/{serialId}",
          method = RequestMethod.DELETE,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Sink> delete(
          @PathVariable("serialId") String serialId) {

    return sinkService.deleteEntityBySerialId(serialId);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Sink dummy() {

    return new Sink(
            "123456789",
            "Serra Cagne");
  }
}