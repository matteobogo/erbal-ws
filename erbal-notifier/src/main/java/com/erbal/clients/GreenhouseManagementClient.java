package com.erbal.clients;

import com.erbal.MessageDTO;
import com.erbal.Node;
import com.erbal.Sink;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "erbal-greenhouse-management")
public interface GreenhouseManagementClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/erbal-greenhouse-management/nodes/{nodeId}")
    MessageDTO<Node> findNodeBySerialId(
            @PathVariable("nodeId") String nodeId);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/erbal-greenhouse-management/sinks/{sinkId}")
    MessageDTO<Sink> findSinkBySerialId(
            @PathVariable("sinkId") String sinkId);
}