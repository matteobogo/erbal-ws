package com.erbal.controller;

import com.erbal.domain.dto.IncomingBaseAlert;
import com.erbal.service.NotificationService;
import com.erbal.utils.NotifierParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
   * @param incomingBaseAlert
   */
  @MessageMapping("/notifications/itsme")
  //@SendTo("/topic/itsme/{sinkId}")
  public void itsMeNotification(
          //@DestinationVariable("sinkId") String sinkId
          IncomingBaseAlert incomingBaseAlert) {

    notificationService.genericAlertNotification(incomingBaseAlert, NotifierParams.ALERT_ITS_ME);
  }

  @MessageMapping("/notifications/missingNode")
  public void missingNode(IncomingBaseAlert incomingBaseAlert) {

    notificationService.genericAlertNotification(incomingBaseAlert, NotifierParams.ALERT_MISSING_NODE);
  }

  @MessageMapping("/notifications/lowBattery")
  public void lowBattery(IncomingBaseAlert incomingBaseAlert) {

    notificationService.genericAlertNotification(incomingBaseAlert, NotifierParams.ALERT_LOW_BATTERY);
  }
}