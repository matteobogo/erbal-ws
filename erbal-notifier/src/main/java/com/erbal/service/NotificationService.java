package com.erbal.service;

import com.erbal.domain.dto.IncomingBaseAlert;

public interface NotificationService {

    void genericAlertNotification(IncomingBaseAlert genericAlert, int type);
}