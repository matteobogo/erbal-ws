package com.erbal.controller;

import com.erbal.domain.TerrainSensorsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.erbal.service.RetrieveSensorsDataService;

@RestController
@RequestMapping(value = "sensors/terrain")
public class RetrieveSensorsTerrainDataController extends RetrieveSensorsDataController {

    @Autowired
    RetrieveSensorsDataService retrieveSensorsDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TerrainSensorsData getSensorsDataByTerrainSectorId(
            @PathVariable String id) {

        return retrieveSensorsDataService.findByTerrainSectorId(id);
    }
}