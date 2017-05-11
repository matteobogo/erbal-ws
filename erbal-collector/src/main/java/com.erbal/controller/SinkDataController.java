package com.erbal.controller;

import com.erbal.domain.SinkData;
import com.erbal.service.SinkDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SinkDataController {

    private final SinkDataService sinkDataService;

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
            @RequestBody SinkData sinkData) {

        sinkDataService.add(sinkData);
    }
}