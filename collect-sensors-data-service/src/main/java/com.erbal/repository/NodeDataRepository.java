package com.erbal.repository;

import com.erbal.domain.BaseNodeData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeDataRepository extends MongoRepository<BaseNodeData,String> {
}