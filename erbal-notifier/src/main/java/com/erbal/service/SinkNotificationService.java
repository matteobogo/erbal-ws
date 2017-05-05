package com.erbal.service;

import com.erbal.domain.ItsMeMessage;
import com.erbal.domain.ItsMeResponse;
import com.erbal.domain.SinkTable;

public interface SinkNotificationService {

    ItsMeResponse itsMeNotify(ItsMeMessage itsMeMessage);
    SinkTable updateSinkTable(String sinkId);
}