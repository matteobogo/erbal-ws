package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;
import com.erbal.repository.SinkRepository;

import javax.annotation.PostConstruct;

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

  public void initDatabase() {

    //dummy entries
    Sink sink1 = new Sink(
            "11223344",
            "IPASerra"
    );
    sinkRepository.save(sink1);

    Node node1 = new Node(
            "123456789",
            "Soil",
            "A"
    );
    node1.setSink(sink1);
    nodeRepository.save(node1);

    Node node2 = new Node(
            "987654321",
            "Air",
            "B"
    );
    node2.setSink(sink1);
    nodeRepository.save(node2);
  }
}