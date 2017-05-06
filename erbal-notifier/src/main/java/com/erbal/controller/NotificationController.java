package com.erbal.controller;

import com.erbal.domain.ItsMeMessage;
import com.erbal.domain.ItsMeResponse;
import com.erbal.service.SinkNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController extends ExceptionHandlingController {

    private SinkNotificationService sinkNotificationService;

    @Autowired
    public NotificationController(SinkNotificationService sinkNotificationService) {
        this.sinkNotificationService = sinkNotificationService;
    }

    @RequestMapping(
            value = "/"
    )

    @RequestMapping(
        value = "/itsme",
        method = RequestMethod.POST,
        consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ItsMeResponse itsMe(
            @RequestBody @Valid ItsMeMessage itsMeMessage) {

        return sinkNotificationService.itsMeNotify(itsMeMessage);
    }

    @RequestMapping(
            value = "/itsme/dummy",
            method = RequestMethod.GET
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ItsMeMessage dummy() {

        return new ItsMeMessage(
                "112233",
                "332211",
                "Soil");
    }
}