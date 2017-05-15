package com.erbal.controller;

import com.erbal.domain.SinkData;
import com.erbal.domain.dto.SinkNBatchDTO;
import com.erbal.service.SinkDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(
            value = "/findNBatchBySinkId/{sinkId}/{nBatch}",
            method = RequestMethod.GET
    )
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SinkData> findNBatchBySinkId(
            @PathVariable("sinkId") String sinkId,
            @PathVariable("nBatch") long nBatch) {

        return sinkDataService.findNBatchBySinkId(sinkId,nBatch);
    }

    @RequestMapping(
            value = "/findLastBatchBySinkId/{sinkId}",
            method = RequestMethod.GET
    )
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SinkData> findLastBatchBySinkId(
            @PathVariable("sinkId") String sinkId) {

        return sinkDataService.findLastBatchBySinkId(sinkId);
    }
}