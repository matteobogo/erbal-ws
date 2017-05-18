package com.erbal.client;

import domain.SinkData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "erbal-collector")
public interface CollectorClient {

    @RequestMapping(
            value = "/erbal-collector/findNBatchBySinkId/{sinkId}/{nBatch}",
            method = RequestMethod.GET
    )
    public List<SinkData> findNBatchBySinkId(
            @PathVariable("sinkId") String sinkId,
            @PathVariable("nBatch") long nBatch);
}