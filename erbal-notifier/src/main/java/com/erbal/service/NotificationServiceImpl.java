package com.erbal.service;

import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.dto.IncomingBaseAlert;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Node;
import com.erbal.domain.shared.Sink;
import com.erbal.utils.NotifierParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

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
    public void genericAlertNotification(IncomingBaseAlert genericAlert, int type) {

        //obtain Sink with sinkId from greenhouse-management service
        MessageDTO<Sink> sinkExist = greenhouseManagementClient.findSinkBySerialId(genericAlert.getSinkId());

        //obatain Node with nodeId from greenhouse-management service
        MessageDTO<Node> nodeExist = greenhouseManagementClient.findNodeBySerialId(genericAlert.getNodeId());

        if(sinkExist.getEntity() != null && nodeExist.getEntity() != null) {

            if()

            switch(type) {

                case NotifierParams.ALERT_ITS_ME:

                    //already paired ?
                    if(nodeExist.getEntity().getSink() != null) return;

                    simpMessagingTemplate.convertAndSend("/topic/notifications/itsme/"+sinkExist.getEntity().getUserId(), genericAlert);
                    break;

                case NotifierParams.ALERT_MISSING_NODE:

                    //paired ?
                    if(nodeExist.getEntity().getSink() == null) return;

                    simpMessagingTemplate.convertAndSend("/topic/notifications/missingNode/"+sinkExist.getEntity().getUserId(), genericAlert);
                    break;

                case NotifierParams.ALERT_LOW_BATTERY:

                    //paired ?
                    if(nodeExist.getEntity().getSink() == null) return;

                    simpMessagingTemplate.convertAndSend("/topic/notifications/lowBattery/"+sinkExist.getEntity().getUserId(), genericAlert);
                    break;
            }
        }
    }
}