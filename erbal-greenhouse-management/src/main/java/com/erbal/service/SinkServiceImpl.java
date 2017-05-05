package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.SinkTable;
import com.erbal.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.SinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SinkServiceImpl implements SinkService {

    private SinkRepository sinkRepository;
    private NodeRepository nodeRepository;

    @Autowired
    public SinkServiceImpl(
            SinkRepository sinkRepository,
            NodeRepository nodeRepository) {

        this.sinkRepository = sinkRepository;
        this.nodeRepository = nodeRepository;
    }

    @Override
    public MessageDTO<Sink> add(Sink sink) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"com.erbal.Sink already exist");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(sink.getSinkId());

        if(!sinkExist.isPresent()) {
            message.setEntity(sinkRepository.save(sink));
            message.setDescription("com.erbal.Sink added successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Sink> update(Sink sink) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"com.erbal.Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(sink.getSinkId());

        if(sinkExist.isPresent()) {
            message.setEntity(sinkRepository.save(sink));
            message.setDescription("com.erbal.Sink updated successfully");
        }
        return message;
    }

    @Override
    public List<Sink> getAll() {

        return sinkRepository.findAll();
    }

    @Override
    public MessageDTO<Sink> getEntityBySerialId(String serialId) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"com.erbal.Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(serialId);

        if(sinkExist.isPresent()) {
            message.setEntity(sinkExist.get());
            message.setDescription("com.erbal.Sink retrieved successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Sink> deleteEntityBySerialId(String serialId) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"com.erbal.Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(serialId);

        if(sinkExist.isPresent()) {
            sinkRepository.delete(sinkExist.get());
            message.setEntity(sinkExist.get());
            message.setDescription("com.erbal.Sink deleted successfully");
        }
        return message;
    }

    @Override
    public SinkTable updateSinkTable(String sinkId) {

        SinkTable sinkTable = null;
        Optional<Sink> sink = sinkRepository.findBySinkId(sinkId);

        if(sink.isPresent()) {

            List<Node> nodes = nodeRepository.findAllBySink(sink.get());
            sinkTable = new SinkTable(sinkId,nodes);
        }
        return sinkTable;
    }
}