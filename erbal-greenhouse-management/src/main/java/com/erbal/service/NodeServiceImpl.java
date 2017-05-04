package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NodeServiceImpl implements CrudService<Node> {

    private NodeRepository nodeRepository;

    @Autowired
    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public MessageDTO<Node> add(Node node) {

        MessageDTO<Node> message = new MessageDTO<>(null,"com.erbal.Node already exist");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(node.getNodeId());

        if(!nodeExist.isPresent()) {
            message.setEntity(nodeRepository.save(node));
            message.setDescription("com.erbal.Node added successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Node> update(Node node) {

        MessageDTO<Node> message = new MessageDTO<>(null,"com.erbal.Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(node.getNodeId());

        if(nodeExist.isPresent()) {
            message.setEntity(nodeRepository.save(node));
            message.setDescription("com.erbal.Node updated successfully");
        }
        return message;
    }

    @Override
    public List<Node> getAll() {

        return nodeRepository.findAll();
    }

    @Override
    public MessageDTO<Node> getEntityBySerialId(String serialId) {

        MessageDTO<Node> message = new MessageDTO<>(null,"com.erbal.Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(serialId);

        if(nodeExist.isPresent()) {
            message.setEntity(nodeExist.get());
            message.setDescription("com.erbal.Node retrieved successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Node> deleteEntityBySerialId(String serialId) {

        MessageDTO<Node> message = new MessageDTO<>(null,"com.erbal.Node not found");
        Optional<Node> nodeExist = nodeRepository.findByNodeId(serialId);

        if(nodeExist.isPresent()) {
            nodeRepository.delete(nodeExist.get());
            message.setEntity(nodeExist.get());
            message.setDescription("com.erbal.Node deleted successfully");
        }
        return message;
    }
}