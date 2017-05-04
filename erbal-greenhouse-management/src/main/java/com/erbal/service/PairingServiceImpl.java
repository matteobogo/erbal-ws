package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Pair;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.repository.PairRepository;
import com.erbal.repository.UnpairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.NodeRepository;
import com.erbal.repository.SinkRepository;

import java.util.Optional;

@Service
public class PairingServiceImpl implements PairingService {

    private SinkRepository sinkRepository;
    private NodeRepository nodeRepository;
    private PairRepository pairRepository;
    private UnpairRepository unpairRepository;

    @Autowired
    public PairingServiceImpl(
            SinkRepository sinkRepository,
            NodeRepository nodeRepository,
            PairRepository pairRepository,
            UnpairRepository unpairRepository
    ) {
        this.sinkRepository = sinkRepository;
        this.nodeRepository = nodeRepository;
        this.pairRepository = pairRepository;
        this.unpairRepository = unpairRepository;
    }

    @Override
    public MessageDTO<Pair> pair(Pair pair) {

        MessageDTO<Pair> result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySinkId(pair.getSinkId());
        Optional<Node> nodePaired = nodeRepository.findByNodeId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();
            Sink sink = sinkPaired.get();

            result = new MessageDTO<>(
                    pair,
                    "com.erbal.Node already paired"
            );

            if(node.getSink() == null) {

                node.setSink(sink);
                node.setSector(pair.getSectorId());

                nodeRepository.save(node);
                pairRepository.save(pair);

                result.setDescription("com.erbal.Node paired");
            }
        }
        return result;
    }

    @Override
    public MessageDTO<Pair> unpair(Pair pair) {

        MessageDTO<Pair> result = null;

        Optional<Sink> sinkPaired = sinkRepository.findBySinkId((pair.getSinkId()));
        Optional<Node> nodePaired = nodeRepository.findByNodeId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();

            result = new MessageDTO<>(
                    pair,
                    "com.erbal.Node not paired"
            );

            if(node.getSink() != null) {

                node.setSink(null);
                node.setSector("");

                nodeRepository.save(node);
                unpairRepository.save(pair);

                result.setDescription("com.erbal.Node unpaired");
            }
        }
        return result;
    }

    private void updateSinkTable() {

        //Spring STOMP con le websocket (riprendi la connessione con il sink)
        //invio lista nodi associati al sink
    }
}