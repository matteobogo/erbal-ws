package com.erbal.service;

import com.erbal.domain.ItsMeMessage;
import com.erbal.domain.SinkTable;

public interface SinkNotificationService {

    void itsMeNotify(ItsMeMessage itsMeMessage);
    SinkTable updateSinkTable(String sinkId);
}