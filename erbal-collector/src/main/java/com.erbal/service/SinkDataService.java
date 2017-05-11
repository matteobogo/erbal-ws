package com.erbal.service;

import java.util.Collection;

public interface SinkDataService<T> {

    void add(T sinkData);
    Collection<T> findAll();
}