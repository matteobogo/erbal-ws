package com.erbal.repository;

import com.erbal.domain.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodeRepository extends MongoRepository<Node,String> {

    Optional<Node> findByNodeId(String nodeId);
}