package com.erbal.controller;

import com.erbal.domain.dto.BatchStatsDTO;
import com.erbal.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(
            value = "/findNBatchBySinkId/{userId}/{sinkId}/{nBatch}",
            method = RequestMethod.GET
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BatchStatsDTO findNBatchBySinkId(
            @PathVariable("userId") String userId,
            @PathVariable("sinkId") String sinkId,
            @PathVariable("nBatch") long nBatch) {

        return statisticsService.findNBatchBySinkId(userId,sinkId,nBatch);
    }
}