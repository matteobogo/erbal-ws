package com.erbal.controller;

import com.erbal.domain.Node;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.erbal.service.CrudService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/nodes")
public class NodeController extends ExceptionHandlingController {

  private CrudService<Node> nodeService;

  @Autowired
  public NodeController(CrudService<Node> nodeService) {
    this.nodeService = nodeService;
  }

  @RequestMapping(
          value = "/add",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
  public MessageDTO<Node> add(
          @RequestBody @Valid Node node) {

    return nodeService.add(node);
  }

  @RequestMapping(
          value = "/update",
          method = RequestMethod.PUT,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Node> update(
          @RequestBody @Valid Node node) {

    return nodeService.update(node);
  }

  @RequestMapping(
          value = "/{serialId}",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Node> findBySerialId(
          @PathVariable("serialId") String serialId) {

    return nodeService.getEntityBySerialId(serialId);
  }

  @RequestMapping(
          value = "/",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Node> findAll() {

    return nodeService.getAll();
  }

  @RequestMapping(
          value = "/delete/{serialId}",
          method = RequestMethod.DELETE,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Node> delete(
          @PathVariable("serialId") String serialId) {

    return nodeService.deleteEntityBySerialId(serialId);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Node dummy() {

    return new Node(
            "123456789",
            "Soil",
            "A");
  }
}