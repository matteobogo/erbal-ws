package com.erbal.repository;

import com.erbal.domain.BaseNodeData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NodeDataRepository extends MongoRepository<BaseNodeData,String> {

    //
}