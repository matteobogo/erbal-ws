package com.erbal.controller;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.ItsMeMessage;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.RegisterSink;
import com.erbal.domain.dto.SinkPreview;
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
          value = "/findAllByUserId/{userId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Sink> findAllByUserId(@PathVariable("userId") String userId) {

    return sinkService.findAllByUserId(userId);
  }

  @RequestMapping(
          value = "/findAllPreviewByUserId/{userId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<SinkPreview> getAllSinkPreview(@PathVariable("userId") String userId) {

    return sinkService.findAllSinkPreview(userId);
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
          value = "/register",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<RegisterSink> register(
          @RequestBody @Valid RegisterSink registerSink) {

    return sinkService.register(registerSink);
  }

  @RequestMapping(
          value = "/unregister",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  public MessageDTO<RegisterSink> unregister(
          @RequestBody @Valid RegisterSink registerSink) {

    return sinkService.unregister(registerSink);
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
            "Serra Cagne",
            "394959hd939ffs3D");
  }
}