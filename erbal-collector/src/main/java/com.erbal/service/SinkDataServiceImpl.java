package com.erbal.service;

import com.erbal.domain.SinkData;
import com.erbal.repository.SinkDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SinkDataServiceImpl implements SinkDataService<SinkData> {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final SinkDataRepository sinkDataRepository;

  @Autowired
  public SinkDataServiceImpl(SinkDataRepository sinkDataRepository) {

    this.sinkDataRepository = sinkDataRepository;
  }

  @Override
  public void add(SinkData sinkData) {

    sinkDataRepository.save(sinkData);

    log.info("Received Sink "+sinkData.getSinkId()+" batch");
  }

  @Override
  public Collection<SinkData> findAll() {

    return sinkDataRepository.findAll();
  }
}