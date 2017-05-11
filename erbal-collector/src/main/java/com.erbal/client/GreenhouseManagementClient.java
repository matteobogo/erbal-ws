package com.erbal.client;

import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Node;
import com.erbal.domain.shared.Sink;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/erbal-greenhouse-management/nodes/findAllBySinkId/{sinkId}"
    )
    List<Node> findAllBySinkId(
            @PathVariable("sinkId") String sinkId);
}