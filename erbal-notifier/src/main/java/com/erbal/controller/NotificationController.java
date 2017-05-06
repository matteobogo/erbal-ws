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
}