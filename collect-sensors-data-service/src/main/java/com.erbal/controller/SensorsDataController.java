package com.erbal.controller;

import com.erbal.domain.AirNodeData;
import com.erbal.domain.TerrainNodeData;
import com.erbal.service.AirNodeDataService;
import com.erbal.service.TerrainNodeDataService;
import com.erbal.validation.AirSensorsDataValidator;
import com.erbal.validation.TerrainSensorsDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sensors/collect")
public class SensorsDataController {

    private final TerrainNodeDataService terrainNodeDataService;
    private final AirNodeDataService airNodeDataService;

    @Autowired
    TerrainSensorsDataValidator terrainSensorsDataValidator;

    @Autowired
    AirSensorsDataValidator airSensorsDataValidator;

    @Autowired
    public SensorsDataController(
            TerrainNodeDataService terrainNodeDataService,
            AirNodeDataService airNodeDataService) {

        this.terrainNodeDataService = terrainNodeDataService;
        this.airNodeDataService = airNodeDataService;
    }

    @RequestMapping(
            value = "/terrain",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void collectTerrainNodeData(
            @RequestBody TerrainNodeData terrainNodeData,
            BindingResult bindingResult) {

        terrainSensorsDataValidator.validate(terrainNodeData, bindingResult);

        if(bindingResult.hasErrors()) {
            //
        }
        terrainNodeDataService.collect(terrainNodeData);
    }

    @RequestMapping(
            value = "/air",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void collectAirNodeData(
            @RequestBody AirNodeData airNodeData,
            BindingResult bindingResult) {

        airSensorsDataValidator.validate(airNodeData, bindingResult);

        if(bindingResult.hasErrors()) {
            //
        }
        airNodeDataService.collect(airNodeData);
    }
}