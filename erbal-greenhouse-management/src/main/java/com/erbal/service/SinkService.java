package com.erbal.service;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.SinkTable;

public interface SinkService extends CrudService<Sink> {

    SinkTable updateSinkTable(String sinkId);
}
