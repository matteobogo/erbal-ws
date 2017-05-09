package com.erbal.repository;

import com.erbal.domain.Sink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SinkRepository extends MongoRepository<Sink,String> {

    Optional<Sink> findBySinkId(String sinkId);
    List<Sink> findAllByUserId(String userId);

    //TODO query
}