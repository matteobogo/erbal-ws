package com.erbal.service;

import com.erbal.domain.TerrainNodeData;
import com.erbal.repository.NodeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.constraints.NotNull;

@Service
public class TerrainNodeDataService extends BaseNodeDataService<TerrainNodeData> {

    @Autowired
    NodeDataRepository nodeDataRepository;

    @Override
    public void collect(@NotNull TerrainNodeData terrainNodeData) {
        nodeDataRepository.save(terrainNodeData);
    }
}