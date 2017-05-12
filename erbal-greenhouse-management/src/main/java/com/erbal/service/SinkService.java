package com.erbal.service;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.*;
import com.erbal.exception.AlreadyRegisteredException;
import com.erbal.exception.AlreadyUnregisteredException;

import java.util.List;

public interface SinkService extends CrudService<Sink> {

    SinkTable updateSinkTable(String sinkId);
    List<Sink> findAllByUserId(String userId);
    List<SinkPreview> findAllSinkPreview(String userId);
    MessageDTO<RegisterSink> register(RegisterSink registerSink) throws AlreadyRegisteredException;
    MessageDTO<RegisterSink> unregister(RegisterSink registerSink) throws AlreadyUnregisteredException;
    List<SinkTable> findAllSinkWithNodesByUserId(String userId);
}
