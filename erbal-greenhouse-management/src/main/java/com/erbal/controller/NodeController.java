package com.erbal.controller;

import com.erbal.domain.Node;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.service.NodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@PreAuthorize("#oauth2.hasScope('server')")
@RequestMapping(value = "/nodes")
public class NodeController extends ExceptionHandlingController {

  private NodeServiceImpl nodeService;

  @Autowired
  public NodeController(NodeServiceImpl nodeService) {
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
          value = "/{nodeId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Node> findBySerialId(
          @PathVariable("nodeId") String nodeId) {

    return nodeService.getEntityBySerialId(nodeId);
  }

  @RequestMapping(
          value = "/",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Node> findAll() {

    return nodeService.getAll();
  }

  @RequestMapping(
          value = "/findAllBySinkId/{sinkId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Node> findAllBySinkId(
          @PathVariable("sinkId") String sinkId) {

    return nodeService.findAllBySinkId(sinkId);
  }

  @RequestMapping(
          value = "/delete/{nodeId}",
          method = RequestMethod.DELETE,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Node> delete(
          @PathVariable("nodeId") String nodeId) {

    return nodeService.deleteEntityBySerialId(nodeId);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET
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