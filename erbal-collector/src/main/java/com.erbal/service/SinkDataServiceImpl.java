package com.erbal.service;

import com.erbal.domain.SinkData;
import com.erbal.repository.SinkDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SinkDataServiceImpl implements SinkDataService<SinkData> {

  private final SinkDataRepository sinkDataRepository;

  @Autowired
  public SinkDataServiceImpl(SinkDataRepository sinkDataRepository) {

    this.sinkDataRepository = sinkDataRepository;
  }

  @Override
  public void add(SinkData sinkData) {

    sinkDataRepository.save(sinkData);
  }

  @Override
  public Collection<SinkData> findAll() {

    return sinkDataRepository.findAll();
  }
}