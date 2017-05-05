package com.erbal.service.websocket;

import com.erbal.Application;
import com.erbal.domain.SinkTable;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SinkSender {

  //private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public SinkSender(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Scheduled(fixedDelay = 3000L)
  public void sendMessage() {
    final SinkTable message = new SinkTable("123",null);
    //log.info("Sending message...");
    rabbitTemplate.convertAndSend(Application.EXCHANGE_NAME, Application.ROUTING_KEY, message);
  }
}