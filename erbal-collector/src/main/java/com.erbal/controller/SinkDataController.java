package com.erbal.controller;

import com.erbal.domain.NodeData;
import com.erbal.domain.AirSampleData;
import com.erbal.domain.SoilSampleData;
import com.erbal.domain.SinkData;
import com.erbal.service.SinkDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SinkDataController {

    private final SinkDataService sinkDataService;

    //@Autowired
    //TerrainSensorsDataValidator terrainSensorsDataValidator;

    //@Autowired
   // AirSensorsDataValidator airSensorsDataValidator;

    @Autowired
    public SinkDataController(
            SinkDataService sinkDataService) {

        this.sinkDataService = sinkDataService;
    }

    @RequestMapping(
            value = "/collect",
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void collect(
            @RequestBody SinkData sinkData
            //BindingResult bindingResult
            ) {

        //terrainSensorsDataValidator.validate(terrainNodeData, bindingResult);

//        if(bindingResult.hasErrors()) {
//            //
//        }

        sinkDataService.add(sinkData);
    }
}



















