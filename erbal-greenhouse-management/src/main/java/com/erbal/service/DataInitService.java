package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;
import com.erbal.repository.SinkRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class DataInitService {

  private NodeRepository nodeRepository;
  private SinkRepository sinkRepository;

  @Autowired
  public DataInitService(
          NodeRepository nodeRepository,
          SinkRepository sinkRepository) {

    this.nodeRepository = nodeRepository;
    this.sinkRepository = sinkRepository;
  }

  @PostConstruct
  public void init() {

    initDatabase();
  }

  private void initDatabase() {

    //dummy entries
    Sink sink1 = null;
    Node node1 = null;
    Node node2 = null;

    Optional<Sink> sinkExist = sinkRepository.findBySinkId("11223344");
    if(!sinkExist.isPresent()) {

      sink1 = new Sink(
              "11223344",
              "",
              ""
      );
      sinkRepository.save(sink1);
    }

    Optional<Node> node1Exist = nodeRepository.findByNodeId("123456789");
    if(!node1Exist.isPresent()) {

      node1 = new Node(
              "123456789",
              "Soil",
              "A"
      );
      node1.setSink(sink1);
      nodeRepository.save(node1);
    }

    Optional<Node> node2Exist = nodeRepository.findByNodeId("987654321");
    if(!node2Exist.isPresent()) {

      node2 = new Node(
              "987654321",
              "Air",
              "B"
      );
      node2.setSink(sink1);
      nodeRepository.save(node2);
    }
  }
}