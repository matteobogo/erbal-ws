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

  private SimpMessagingTemplate simpMessagingTemplate;
  private NotificationService notificationService;

  @Autowired
  public WebSocketController(
          SimpMessagingTemplate simpMessagingTemplate,
          NotificationService notificationService) {

    this.simpMessagingTemplate = simpMessagingTemplate;
    this.notificationService = notificationService;
  }

  /*
    SINK <--> SERVER WebSockets
   */

  @MessageMapping("/notifications/itsme")
  //@SendTo("/topic/itsme/{sinkId}")
  public void itsMeNotification(
          //@DestinationVariable("sinkId") String sinkId
          ItsMeMessage itsMeMessage
  ) {

    notificationService.itsMeNotification(itsMeMessage);
    //simpMessagingTemplate.convertAndSend("/topic/notifications/itsme/1","OK");
  }

  @RequestMapping("/notifications/pairingResult")
  public void pairingResult() {

    //TODO
  }

  @RequestMapping("/notifications/unpairingResult")
  public void unpairingResult() {

    //TODO
  }

  @RequestMapping("/notifications/lowBattery")
  public void lowBattery() {

    //TODO
  }

  @RequestMapping("/notifications/missingNode")
  public void missingNode() {

    //TODO
  }

  /*
    CLIENT <--> SERVER WebSockets
   */

  @MessageMapping("/notifications/pairing")
  public void pairing() {

    //TODO service
    //simpMessagingTemplate.convertAndSend("/topic/notifications/pairing/1","OK");
  }

  @MessageMapping("/notifications/unpairing")
  public void unpairing() {

    //TODO service

  }
}