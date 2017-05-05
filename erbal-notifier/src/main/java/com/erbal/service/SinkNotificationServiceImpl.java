package com.erbal.service;

import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.ItsMeMessage;
import com.erbal.domain.SinkTable;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinkNotificationServiceImpl implements SinkNotificationService {

    //sink connections
    //

    //feign client
    private GreenhouseManagementClient greenhouseManagementClient;

    @Autowired
    public SinkNotificationServiceImpl(
            GreenhouseManagementClient greenhouseManagementClient) {

        this.greenhouseManagementClient = greenhouseManagementClient;
    }

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

    @Override
    public SinkTable updateSinkTable(String sinkId) {

        List<Node> nodes = greenhouseManagementClient.findAllBySinkId(sinkId);



        //check if websocket connection exists

        SinkTable sinkTable = new SinkTable(sinkId,nodes);

        return null;

        //send through websocket list of nodes
    }
}
