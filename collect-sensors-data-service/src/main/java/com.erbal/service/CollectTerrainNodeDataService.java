package com.erbal.service;

import com.erbal.domain.TerrainNodeData;
import com.erbal.repository.CollectTerrainNodeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectTerrainNodeDataService {

    @Autowired
    CollectTerrainNodeDataRepository collectTerrainNodeDataRepository;

    public void collectTerrainNodeData(TerrainNodeData terrainNodeData) {
        collectTerrainNodeDataRepository.save(terrainNodeData);
    }
}