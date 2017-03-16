package com.erbal.repository;

import com.erbal.domain.TerrainNodeData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectTerrainNodeDataRepository extends MongoRepository<TerrainNodeData,String> {

    //
}