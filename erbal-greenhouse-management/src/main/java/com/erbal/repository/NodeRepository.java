package com.erbal.repository;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NodeRepository extends MongoRepository<Node,String> {

    Optional<Node> findByNodeId(String nodeId);
    List<Node> findAllBySink(Sink sink);
}