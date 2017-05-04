package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;
import com.erbal.repository.SinkRepository;

import java.util.Optional;

@Service
public class PairingServiceImpl implements PairingService {

    private SinkRepository sinkRepository;
    private NodeRepository nodeRepository;

    @Autowired
    public PairingServiceImpl(
            SinkRepository sinkRepository,
            NodeRepository nodeRepository
    ) {
        this.sinkRepository = sinkRepository;
        this.nodeRepository = nodeRepository;
    }

    @Override
    public MessageDTO<Pair> pair(Pair pair) {

        MessageDTO<Pair> result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySerialId(pair.getSinkId());
        Optional<Node> nodePaired = nodeRepository.findBySerialId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();
            Sink sink = sinkPaired.get();

            result = new MessageDTO<>(
                    pair,
                    "Node already paired"
            );

            if(node.getSink() == null) {

                node.setSink(sink);
                node.setSector(pair.getSectorId());

                nodeRepository.save(node);

                result.setDescription("Node paired");
            }
        }
        return result;
    }

    @Override
    public MessageDTO<Pair> unpair(Pair pair) {

        MessageDTO<Pair> result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySerialId((pair.getSinkId()));
        Optional<Node> nodePaired = nodeRepository.findBySerialId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();

            result = new MessageDTO<>(
                    pair,
                    "Node not paired"
            );

            if(node.getSink() != null) {

                node.setSink(null);
                node.setSector("");

                nodeRepository.save(node);

                result.setDescription("Node unpaired");
            }
        }
        return result;
    }
}