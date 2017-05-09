//package com.erbal.controller;
//
//import com.erbal.domain.SinkTable;
//import com.erbal.service.SinkNotificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.DestinationVariable;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@controller
//@RequestMapping(value = "/connections/sinks")
//public class SinkWebSocketController {
//
//  @MessageMapping("/{sinkId}")
//  @SendTo("/topic/table/{sinkId}")
//  public SinkTable updateSinkTable(
//          @DestinationVariable String sinkId,
//          SinkTable sinkTable) {
//
//    return sinkTable;
//  }
//}