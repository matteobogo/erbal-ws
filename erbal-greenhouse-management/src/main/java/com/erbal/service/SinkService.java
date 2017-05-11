package com.erbal.service;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.*;

import java.util.List;

public interface SinkService extends CrudService<Sink> {

    SinkTable updateSinkTable(String sinkId);
    List<Sink> findAllByUserId(String userId);
    List<SinkPreview> findAllSinkPreview(String userId);
    MessageDTO<RegisterSink> register(RegisterSink registerSink);
    MessageDTO<RegisterSink> unregister(RegisterSink registerSink);
    List<SinkTable> findAllSinkWithNodesByUserId(String userId);
}
