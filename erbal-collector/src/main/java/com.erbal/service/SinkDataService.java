package com.erbal.service;

import com.erbal.domain.SinkData;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public interface SinkDataService<T> {

    void add(@NotNull T sinkData);
    Collection<SinkData> findAll();
}