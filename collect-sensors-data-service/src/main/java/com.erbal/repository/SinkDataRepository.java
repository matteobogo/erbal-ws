package com.erbal.repository;

import com.erbal.domain.SinkData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinkDataRepository extends MongoRepository<SinkData,String> {

  //
}