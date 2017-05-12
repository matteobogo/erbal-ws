package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Pair;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.exception.AlreadyPairedException;
import com.erbal.exception.AlreadyUnpairedException;
import com.erbal.repository.NodeRepository;
import com.erbal.repository.PairRepository;
import com.erbal.repository.SinkRepository;
import com.erbal.repository.UnpairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PairingServiceImpl implements PairingService {

    private final Logger log = LoggerFactory.getLogger(getClass());

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
    public MessageDTO<Pair> pair(Pair pair)
            throws AlreadyPairedException, EntityNotFoundException {

        MessageDTO<Pair> result;

        Optional<Sink> sinkPaired = sinkRepository.findBySinkId(pair.getSinkId());
        Optional<Node> nodePaired = nodeRepository.findByNodeId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();
            Sink sink = sinkPaired.get();

            if(node.getSink() == null) {

                node.setSink(sink);
                node.setSectorId(pair.getSectorId());

                nodeRepository.save(node);
                pairRepository.save(pair);

                result = new MessageDTO<>(pair,"Node paired");

                log.info("Node "+pair.getNodeId()+" paired with Sink "+pair.getSinkId()+" for Sector "+pair.getSectorId());
            }
            else throw new AlreadyPairedException();
        }
        else throw new EntityNotFoundException();

        return result;
    }

    @Override
    public MessageDTO<Pair> unpair(Pair pair)
            throws AlreadyUnpairedException, EntityNotFoundException {

        MessageDTO<Pair> result;

        Optional<Sink> sinkPaired = sinkRepository.findBySinkId((pair.getSinkId()));
        Optional<Node> nodePaired = nodeRepository.findByNodeId(pair.getNodeId());

        if(sinkPaired.isPresent() && nodePaired.isPresent()) {

            Node node = nodePaired.get();

            if(node.getSink() != null) {

                node.setSink(null);
                node.setSectorId("");

                nodeRepository.save(node);
                unpairRepository.save(pair);

                result = new MessageDTO<>(pair,"Node unpaired");

                log.info("Node "+pair.getNodeId()+" paired with Sink "+pair.getSinkId()+" for Sector "+
                        pair.getSectorId()+" is unpaired");
            }
            else throw new AlreadyUnpairedException();
        }
        else throw new EntityNotFoundException();

        return result;
    }
}