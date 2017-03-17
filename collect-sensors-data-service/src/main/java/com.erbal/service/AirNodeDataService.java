package com.erbal.service;

import com.erbal.domain.AirNodeData;
import com.erbal.repository.NodeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class AirNodeDataService extends BaseNodeDataService<AirNodeData> {

    @Autowired
    NodeDataRepository nodeDataRepository;

    @Override
    public void collect(@NotNull AirNodeData airNodeData) {
        nodeDataRepository.save(airNodeData);
    }
}
