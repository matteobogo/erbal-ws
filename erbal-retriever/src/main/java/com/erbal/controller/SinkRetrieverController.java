package com.erbal.controller;

import com.erbal.domain.SinkPreview;
import com.erbal.service.SinkRetrieverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retrieve")
public class SinkRetrieverController {

    private SinkRetrieverService sinkRetrieverService;

    @Autowired
    public SinkRetrieverController(SinkRetrieverService sinkRetrieverService) {

        this.sinkRetrieverService = sinkRetrieverService;
    }

    @RequestMapping(
            value = "/getAllSinkPreviewByUserId/{userId}",
            method = RequestMethod.GET
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<SinkPreview> getAllSinkPreview(@PathVariable("userId") String userId) {

        return sinkRetrieverService.findAllSinkPreview(userId);
    }
}