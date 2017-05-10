package com.erbal.service;

import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.dto.ItsMeMessage;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Sink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private GreenhouseManagementClient greenhouseManagementClient;
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public NotificationServiceImpl(
            GreenhouseManagementClient greenhouseManagementClient,
            SimpMessagingTemplate simpMessagingTemplate) {

        this.greenhouseManagementClient = greenhouseManagementClient;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @Override
    public void itsMeNotification(ItsMeMessage itsMeMessage) {

        //obtain Sink with sinkId from greenhouse-management service
        MessageDTO<Sink> sinkExist = greenhouseManagementClient.findSinkBySerialId(itsMeMessage.getSinkId());
        Optional<Sink> sink = Optional.of(sinkExist.getEntity());

        if(sink.isPresent()) {

            //populate itsMeMessage with GreenHouse name
            itsMeMessage.setGreenHouseName(sink.get().getGreenhouseName());

            //send ItsMe with websocket to webclient
            // ../topic/itsme/userId endpoint where
            simpMessagingTemplate.convertAndSend("/topic/notifications/itsme/"+sink.get().getUserId(),itsMeMessage);
        }
    }
}