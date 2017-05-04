package com.erbal.service;

import com.erbal.MessageDTO;
import com.erbal.Node;
import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.ItsMeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SinkNotificationServiceImpl implements SinkNotificationService {

    @Autowired
    GreenhouseManagementClient greenhouseManagementClient;

    @Override
    public void itsMeNotify(ItsMeMessage itsMeMessage) {

        Optional<MessageDTO<Node>> node = Optional.of(
                greenhouseManagementClient
                        .findNodeBySerialId(itsMeMessage.getNodeId()));

        Optional<MessageDTO> sink = Optional.of(
                greenhouseManagementClient
                        .findSinkBySerialId(itsMeMessage.getSinkId()));

        if(node.isPresent() && sink.isPresent()) {

            if(node.get().getEntity().getType().equals(itsMeMessage.getType())) {

                //test
                System.out.println("OK");
                System.out.println(node.get());

                //TODO send to client
                //TODO gestione errori con httpstatus ? x sink intelligente
            }
        }
    }
}
