package com.erbal.service;

import com.erbal.domain.AirNodeData;
import com.erbal.repository.NodeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class AirNodeDataService implements NodeDataService<AirNodeData> {

    private final NodeDataRepository nodeDataRepository;

    @Autowired
    public AirNodeDataService(NodeDataRepository nodeDataRepository) {
        this.nodeDataRepository = nodeDataRepository;
    }

    @Override
    public void collect(@NotNull AirNodeData airNodeData) {
        nodeDataRepository.save(airNodeData);
    }
}
