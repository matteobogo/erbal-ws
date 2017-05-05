//package com.erbal.service.websocket;
//
//import com.erbal.Application;
//import com.erbal.domain.SinkTable;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SinkListener {
//
//  //private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);
//
//  @RabbitListener(queues = Application.QUEUE_GENERIC_NAME)
//  public void receiveMessage(final Message message) {
//    //log.info("Received message as generic: {}", message.toString());
//  }
//
//  @RabbitListener(queues = Application.QUEUE_SPECIFIC_NAME)
//  public void receiveMessage(final SinkTable customMessage) {
//    //log.info("Received message as specific class: {}", customMessage.toString());
//  }
//}