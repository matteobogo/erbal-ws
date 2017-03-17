package com.erbal.controller;

import com.erbal.domain.AirNodeData;
import com.erbal.domain.TerrainNodeData;
import com.erbal.service.AirNodeDataService;
import com.erbal.service.TerrainNodeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sensors/collect")
public class SensorsDataController extends ExceptionHandlerController {

    @Autowired
    TerrainNodeDataService terrainNodeDataService;

    @Autowired
    AirNodeDataService airNodeDataService;

    @RequestMapping(
            value = "/terrain",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void collectTerrainNodeData(@Valid @RequestBody TerrainNodeData terrainNodeData) {

        terrainNodeDataService.collect(terrainNodeData);
    }

    @RequestMapping(
            value = "/air",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void collectAirNodeData(@Valid @RequestBody AirNodeData airNodeData) {

        airNodeDataService.collect(airNodeData);
    }
}