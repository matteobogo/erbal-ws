package com.erbal.service;

import com.erbal.domain.TerrainSensorsData;
import com.erbal.repository.RetrieveSensorsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetrieveSensorsDataService {

    @Autowired
    RetrieveSensorsDataRepository retrieveSensorsDataRepository;

    public TerrainSensorsData findByTerrainSectorId(String terrainSectorId) {
        return retrieveSensorsDataRepository.findOne(terrainSectorId);
    }
}
