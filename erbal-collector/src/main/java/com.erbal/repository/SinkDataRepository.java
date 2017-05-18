package com.erbal.repository;

import com.erbal.domain.SinkData;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinkDataRepository extends MongoRepository<SinkData,String> {

  List<SinkData> findTop100BySinkIdOrderByCreatedAt(String sinkId, Sort sort);
  List<SinkData> findTop1BySinkIdOrderByCreatedAt(String sinkId, Sort sort);
}