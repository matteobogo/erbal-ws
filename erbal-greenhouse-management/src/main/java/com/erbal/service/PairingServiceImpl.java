package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.PairDTO;
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
    public PairDTO pair(PairDTO pairDTO) {

        PairDTO result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySerialId(pairDTO.getSinkId());
        Optional<Node> nodePaired = nodeRepository.findBySerialId(pairDTO.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();
            Sink sink = sinkPaired.get();

            result = new PairDTO(
                    pairDTO.getSinkId(),
                    pairDTO.getNodeId(),
                    pairDTO.getSector(),
                    "Node already paired"
            );

            if(node.getSink() == null) {

                node.setSink(sink);
                node.setSector(pairDTO.getSector());

                nodeRepository.save(node);

                result.setDescription("Node paired");
            }
        }
        return result;
    }

    @Override
    public PairDTO unpair(PairDTO pairDTO) {

        PairDTO result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySerialId((pairDTO.getSinkId()));
        Optional<Node> nodePaired = nodeRepository.findBySerialId(pairDTO.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();

            result = new PairDTO(
                    pairDTO.getSinkId(),
                    pairDTO.getNodeId(),
                    pairDTO.getSector(),
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