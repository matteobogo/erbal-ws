package com.erbal.service;

import com.erbal.domain.dto.ItsMeMessage;

public interface NotificationService {

    void itsMeNotification(ItsMeMessage itsMeMessage);
    //void lowBatteryNotification(...);
    //void missingNodeNotification(...);
}