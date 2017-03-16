package com.erbal.controller;

import com.erbal.domain.TerrainNodeData;
import com.erbal.service.CollectTerrainNodeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sensors/terrain")
public class CollectTerrainSensorsDataController {

    @Autowired
    CollectTerrainNodeDataService collectTerrainNodeDataService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void setTerrainNodeData(
            @Valid
            @RequestBody
                    TerrainNodeData terrainNodeData) {

        collectTerrainNodeDataService.collectTerrainNodeData(terrainNodeData);
    }
}