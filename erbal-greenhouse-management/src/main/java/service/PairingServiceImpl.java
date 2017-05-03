package service;

import domain.Node;
import domain.Sink;
import domain.dto.PairDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NodeRepository;
import repository.SinkRepository;

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
                    ""
            );

            if(node.getSink() == null) {

                node.setSink(sink);
                node.setSector(pairDTO.getSector());

                nodeRepository.save(node);

                result.setDescription("Node paired");
            }
            else
                result.setDescription("Node already paired");
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
                    ""
            );

            if(node.getSink() != null) {

                node.setSink(null);
                node.setSector("");

                nodeRepository.save(node);

                result.setDescription("Node unpaired");
            }
            else
                result.setDescription("Node not paired");
        }
        return result;
    }
}