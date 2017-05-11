package com.erbal.controller;

import com.erbal.domain.dto.ItsMeMessage;
import com.erbal.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

  private SimpMessagingTemplate simpMessagingTemplate;  //TODO dopo i test toglilo
  private NotificationService notificationService;

  @Autowired
  public WebSocketController(
          SimpMessagingTemplate simpMessagingTemplate,
          NotificationService notificationService) {

    this.simpMessagingTemplate = simpMessagingTemplate;
    this.notificationService = notificationService;
  }

  //
  //SINK <--> SERVER WebSockets
  //

  /**
   * Endpoint where sinks push the ItsMe Message
   * @param itsMeMessage
   */
  @MessageMapping("/notifications/itsme")
  //@SendTo("/topic/itsme/{sinkId}")
  public void itsMeNotification(
          //@DestinationVariable("sinkId") String sinkId
          ItsMeMessage itsMeMessage) {

    notificationService.itsMeNotification(itsMeMessage);
  }

  @RequestMapping("/notifications/lowBattery")
  public void lowBattery() {

    //TODO
  }

  @RequestMapping("/notifications/missingNode")
  public void missingNode() {

    //TODO
  }
}