package com.erbal.service;

import com.erbal.domain.SinkData;
import com.erbal.domain.dto.SinkNBatchDTO;

import java.util.List;

public interface SinkDataService {

    void add(SinkData sinkData);
    List<SinkData> findNBatchBySinkId(String sinkId, long nBatch);
    List<SinkData> findLastBatchBySinkId(String sinkId);
}