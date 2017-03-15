package com.erbal.service;

import com.erbal.domain.TerrainSector;
import com.erbal.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    @Autowired
    SensorDataRepository sensorDataRepository;

    public TerrainSector findByTerrainSectorId(String terrainSectorId) {
        return sensorDataRepository.findOne(terrainSectorId);
    }
}
