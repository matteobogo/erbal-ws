package com.erbal.client;

import com.erbal.shared.Sink;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "erbal-greenhouse-management")
public interface GreenhouseManagementClient {

    @RequestMapping(
            value = "/erbal-greenhouse-management/sinks/findAllByUserId/{userId}",
            method = RequestMethod.GET
    )
    List<Sink> findAllByUserId(
            @PathVariable("userId") String userId);
}