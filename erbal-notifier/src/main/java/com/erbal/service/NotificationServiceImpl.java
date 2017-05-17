package com.erbal.service;

import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.dto.ItsMeMessage;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Node;
import com.erbal.domain.shared.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final Logger log = LoggerFactory.getLogger(getClass());

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

        //obatain Node with nodeId from greenhouse-management service
        MessageDTO<Node> nodeExist = greenhouseManagementClient.findNodeBySerialId(itsMeMessage.getNodeId());

        if(sinkExist.getEntity() != null && nodeExist.getEntity() != null) {

            //already paired ?
            if(nodeExist.getEntity().getSink() != null) return;

            //populate itsMeMessage with GreenHouse name
            itsMeMessage.setGreenHouseName(sinkExist.getEntity().getGreenhouseName());

            log.info("ItsMe received from Node "+itsMeMessage.getNodeId()+" of type "+itsMeMessage.getType()+" by Sink "+itsMeMessage.getSinkId());

            //send ItsMe with websocket to webclient    ../topic/notifications/itsme/userId
            simpMessagingTemplate.convertAndSend("/topic/notifications/itsme/"+sinkExist.getEntity().getUserId(),itsMeMessage);
        }
    }
}