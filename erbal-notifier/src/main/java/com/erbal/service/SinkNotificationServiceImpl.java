package com.erbal.service;

import com.erbal.clients.GreenhouseManagementClient;
import com.erbal.domain.ItsMeMessage;
import com.erbal.domain.ItsMeResponse;
import com.erbal.domain.SinkTable;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public ItsMeResponse itsMeNotify(ItsMeMessage itsMeMessage) {
        return null;
    }

    @Override
    public SinkTable updateSinkTable(String sinkId) {
        return null;
    }
}