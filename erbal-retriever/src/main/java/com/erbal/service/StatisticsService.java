package com.erbal.service;

import com.erbal.domain.dto.BatchStatsDTO;

import java.util.List;

public interface StatisticsService {

    BatchStatsDTO findNBatchBySinkId(String userId, String sinkId, long nBatch);
}