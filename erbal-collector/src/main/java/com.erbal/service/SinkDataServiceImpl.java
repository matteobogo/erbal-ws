package com.erbal.service;

import com.erbal.client.GreenhouseManagementClient;
import com.erbal.domain.SinkData;
import com.erbal.domain.shared.MessageDTO;
import com.erbal.domain.shared.Sink;
import com.erbal.repository.SinkDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

@Service
public class SinkDataServiceImpl implements SinkDataService {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private SinkDataRepository sinkDataRepository;
  private GreenhouseManagementClient greenhouseManagementClient;

  @Autowired
  public SinkDataServiceImpl(
          SinkDataRepository sinkDataRepository,
          GreenhouseManagementClient greenhouseManagementClient) {

    this.sinkDataRepository = sinkDataRepository;
    this.greenhouseManagementClient = greenhouseManagementClient;
  }

  @Override
  public void add(SinkData sinkData) {

    MessageDTO<Sink> sinkExist = greenhouseManagementClient.findSinkBySerialId(sinkData.getSinkId());

    if(sinkExist.getEntity() != null &&
            sinkExist.getEntity().getUserId() != null &&
            !sinkExist.getEntity().getUserId().equals("")) {

      sinkDataRepository.save(sinkData);

      log.info("Received Sink "+sinkData.getSinkId()+" batch");
    }
  }

  @Override
  public List<SinkData> findNBatchBySinkId(String sinkId, long nBatch) {

    List<SinkData> sinkDataList = sinkDataRepository.findTop100BySinkIdOrderByCreatedAt(
            sinkId,
            new Sort(Sort.Direction.DESC, "CreatedAt")
    )
            .stream()
            .limit(nBatch)
            .collect(Collectors.toList());

    reverse(sinkDataList);
    return sinkDataList;
  }

  @Override
  public List<SinkData> findLastBatchBySinkId(String sinkId) {
    return sinkDataRepository.findTop1BySinkIdOrderByCreatedAt(
            sinkId,
            new Sort(Sort.Direction.DESC, "CreatedAt")
    );
  }
}