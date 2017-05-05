package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Pair;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.ItsMeMessage;
import com.erbal.domain.dto.ItsMeResponse;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.SinkTable;
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

    @Override
    public ItsMeResponse itsMeNotify(ItsMeMessage itsMeMessage) {

        ItsMeResponse itsMeResponse = null;

        Optional<Node> node = nodeRepository.findByNodeId(itsMeMessage.getNodeId());
        Optional<Sink> sink = sinkRepository.findBySinkId(itsMeMessage.getSinkId());

        if(node.isPresent() && sink.isPresent()) {

            Node retrievedNode = node.get();

            if (retrievedNode.getType().equals(itsMeMessage.getType())) {

                itsMeResponse = new ItsMeResponse(retrievedNode.getNodeId());

                if (retrievedNode.getSink() == null) {

                    //test
                    System.out.println("OK");
                    System.out.println(node.get());

                    itsMeResponse.setPaired(true);
                } else {

                    itsMeResponse.setPaired(false);
                }

                //TODO send to client
                //TODO gestione errori con httpstatus ? x sink intelligente
            }
        }
        return itsMeResponse;
    }
}