package com.erbal.service;

import com.erbal.domain.SinkPreview;
import java.util.List;

public interface SinkRetrieverService {

    List<SinkPreview> findAllSinkPreview(String userId);
}