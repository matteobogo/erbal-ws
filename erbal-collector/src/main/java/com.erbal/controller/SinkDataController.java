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
            value = "/dummy",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SinkData getDummy() {

        List<NodeData> nodeDataList = new ArrayList<>();

        //air sample
        nodeDataList.add(new NodeData(
                "12345",
                "20/01/2017 03:00",
                123,
                new AirSampleData(
                        20,
                        21,
                        22,
                        23)
        ));

        //soil sample
        nodeDataList.add(new NodeData(
                "54321",
                "20/01/2017 3:15",
                321,
                new SoilSampleData(
                        30,
                        35
                )
        ));

        return new SinkData(
                "123456789",
                nodeDataList);
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



















