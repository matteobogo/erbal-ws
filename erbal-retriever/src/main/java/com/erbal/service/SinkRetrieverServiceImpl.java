package com.erbal.service;

import com.erbal.client.GreenhouseManagementClient;
import com.erbal.domain.SinkPreview;
import com.erbal.domain.shared.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class SinkRetrieverServiceImpl implements SinkRetrieverService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private GreenhouseManagementClient greenhouseManagementClient;

    @Autowired
    public SinkRetrieverServiceImpl(
            GreenhouseManagementClient greenhouseManagementClient) {
        this.greenhouseManagementClient = greenhouseManagementClient;
    }

    @Override
    public List<SinkPreview> findAllSinkPreview(String userId) {

        //obtain sink list from userId from Greenhouse Management Service
        List<Sink> sinkList =
                greenhouseManagementClient.findAllByUserId(userId);

        log.info("Retrieved Sink List ["+sinkList.size()+"] from Greenhouse Service by UserID "+userId);

        List<SinkPreview> sinkPreviewList = new ArrayList<>();

        sinkList.stream()
                .sorted(Comparator.comparing(Sink::getGreenhouseName))
                .forEach(e -> sinkPreviewList.add(new SinkPreview(e.getSinkId(), e.getGreenhouseName())));

        return sinkPreviewList;
    }
}