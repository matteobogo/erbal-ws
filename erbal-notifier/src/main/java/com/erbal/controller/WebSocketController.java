package com.erbal.controller;

import com.erbal.domain.SinkTable;
import com.erbal.service.SinkNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

  private SimpMessagingTemplate simpMessagingTemplate;

  @Autowired
  public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
    this.simpMessagingTemplate = simpMessagingTemplate;
  }

  @MessageMapping("/itsme/{sinkId}")
  //@SendTo("/topic/itsme/{sinkId}")
  public void websocket(
          @DestinationVariable("sinkId") String sinkId) {

    simpMessagingTemplate.convertAndSend("/topic/itsme/"+sinkId,"OK");

  }

//  @RequestMapping(value = "/test/{sinkId}", method = RequestMethod.GET)
//  public void test(@PathVariable("sinkId") String sinkId) {
//    websocket(sinkId);
//  }
}