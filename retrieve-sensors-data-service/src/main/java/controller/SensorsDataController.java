package controller;

import domain.TerrainSector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.SensorDataService;

@RestController
public class SensorsDataController {

    @Autowired
    SensorDataService sensorDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TerrainSector getSensorsDataByTerrainSectorId(
            @PathVariable String id) {
        return sensorDataService.findByTerrainSectorId(id);
    }
}