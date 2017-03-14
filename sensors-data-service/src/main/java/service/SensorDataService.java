package service;

import domain.TerrainSector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SensorDataRepository;

@Service
public class SensorDataService {

    @Autowired
    SensorDataRepository sensorDataRepository;

    public TerrainSector findByTerrainSectorId(String terrainSectorId) {
        return sensorDataRepository.findOne(terrainSectorId);
    }
}
