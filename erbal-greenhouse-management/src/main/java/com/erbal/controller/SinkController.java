package com.erbal.controller;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.service.SinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/sinks")
public class SinkController extends ExceptionHandlingController {

  private SinkServiceImpl sinkService;

  @Autowired
  public SinkController(SinkServiceImpl sinkService) { this.sinkService = sinkService; }

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
          value = "/{sinkId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Sink> findBySerialId(
          @PathVariable("sinkId") String sinkId) {

    return sinkService.getEntityBySerialId(sinkId);
  }

  @RequestMapping(
          value = "/",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Sink> findAll() {

    return sinkService.getAll();
  }

  @RequestMapping(
          value = "/delete/{sinkId}",
          method = RequestMethod.DELETE,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Sink> delete(
          @PathVariable("sinkId") String sinkId) {

    return sinkService.deleteEntityBySerialId(sinkId);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Sink dummy() {

    return new Sink(
            "123456789",
            "Serra Cagne");
  }
}