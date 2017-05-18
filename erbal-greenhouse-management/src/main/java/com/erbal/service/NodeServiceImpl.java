package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.repository.SinkRepository;
import domain.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements NodeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private NodeRepository nodeRepository;
    private SinkRepository sinkRepository;

    @Autowired
    public NodeServiceImpl(
            NodeRepository nodeRepository,
            SinkRepository sinkRepository) {

        this.nodeRepository = nodeRepository;
        this.sinkRepository = sinkRepository;
    }

    @Override
    public MessageDTO<Node> add(Node node) {

        MessageDTO<Node> message = new MessageDTO<>(null,"Node already exist");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(node.getNodeId());

        if(!nodeExist.isPresent()) {
            message.setEntity(nodeRepository.save(node));
            message.setDescription("Node added successfully");

            log.info("Node "+node.getNodeId()+" added successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Node> update(Node node) {

        MessageDTO<Node> message = new MessageDTO<>(null,"Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(node.getNodeId());

        if(nodeExist.isPresent()) {
            message.setEntity(nodeRepository.save(node));
            message.setDescription("Node updated successfully");

            log.info("Node "+node.getNodeId()+" updated successfully");
        }
        return message;
    }

    @Override
    public List<Node> getAll() {

        return nodeRepository.findAll();
    }

    @Override
    public MessageDTO<Node> getEntityBySerialId(String serialId) {

        MessageDTO<Node> message = new MessageDTO<>(null,"Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(serialId);

        if(nodeExist.isPresent()) {
            message.setEntity(nodeExist.get());
            message.setDescription("Node retrieved successfully");
        }
        return message;
    }

    public List<Node> findAllBySinkId(String sinkId) {

        List<Node> nodes = null;
        Optional<Sink> sink = sinkRepository.findBySinkId(sinkId);

        if(sink.isPresent()) {

            nodes = nodeRepository.findAllBySink(sink.get());
        }
        return nodes;
    }

    @Override
    public MessageDTO<Node> deleteEntityBySerialId(String serialId) {

        MessageDTO<Node> message = new MessageDTO<>(null,"Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(serialId);

        if(nodeExist.isPresent()) {
            nodeRepository.delete(nodeExist.get());
            message.setEntity(nodeExist.get());
            message.setDescription("Node deleted successfully");

            log.info("Node "+serialId+" deleted successfully");
        }
        return message;
    }

    @Override
    public String findSectorIdByNodeId(String nodeId) {

        String response = "";

        Optional<Node> node = nodeRepository.findByNodeId(nodeId);
        if(node.isPresent()) {
            response = node.get().getSectorId();
        }
        return response;
    }
}