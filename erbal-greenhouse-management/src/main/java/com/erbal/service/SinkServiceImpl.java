package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.RegisterSink;
import com.erbal.domain.dto.SinkTable;
import com.erbal.repository.NodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.SinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SinkServiceImpl implements SinkService {

    private final Logger log = LoggerFactory.getLogger(getClass());

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

        MessageDTO<Sink> message = new MessageDTO<>(null,"Sink already exist");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(sink.getSinkId());

        if(!sinkExist.isPresent()) {
            message.setEntity(sinkRepository.save(sink));
            message.setDescription("Sink added successfully");

            log.info("Sink "+ sink.getSinkId()+" for Greenhouse "+sink.getGreenhouseName()+" added successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Sink> update(Sink sink) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(sink.getSinkId());

        if(sinkExist.isPresent()) {
            message.setEntity(sinkRepository.save(sink));
            message.setDescription("Sink updated successfully");

            log.info("Sink "+sink.getSinkId()+" for Greenhouse "+sink.getGreenhouseName()+" updated successfully");
        }
        return message;
    }

    @Override
    public List<Sink> getAll() {

        return sinkRepository.findAll();
    }

    @Override
    public MessageDTO<Sink> getEntityBySerialId(String serialId) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(serialId);

        if(sinkExist.isPresent()) {
            message.setEntity(sinkExist.get());
            message.setDescription("Sink retrieved successfully");
        }
        return message;
    }

    @Override
    public MessageDTO<Sink> deleteEntityBySerialId(String serialId) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(serialId);

        if(sinkExist.isPresent()) {
            sinkRepository.delete(sinkExist.get());
            message.setEntity(sinkExist.get());
            message.setDescription("Sink deleted successfully");

            log.info("Sink "+serialId+" for Greenhouse "+sinkExist.get().getGreenhouseName()+" deleted successfully");
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

    @Override
    public List<Sink> findAllByUserId(String userId) {

        //check user id with feign client ?

        return sinkRepository.findAllByUserId(userId);
    }

    @Override
    public MessageDTO<RegisterSink> register(RegisterSink registerSink) {

        MessageDTO<RegisterSink> messageDTO = new MessageDTO<>(registerSink,"Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(registerSink.getSinkId());
        if(sinkExist.isPresent()) {

            Sink sink = sinkExist.get();
            //is it already bound ?
            if(!sink.getUserId().equals("")) {

                messageDTO.setDescription("Sink is already registered");
            }
            else {

                sink.setUserId(registerSink.getUserId());
                sink.setGreenhouseName(registerSink.getGreenhouseName());
                sinkRepository.save(sink);

                log.info("Sink "+sink.getSinkId()+" registered with ClientID "+sink.getUserId());

                messageDTO.setDescription("Sink registered successfully");
            }
        }
        return messageDTO;
    }

    @Override
    public MessageDTO<RegisterSink> unregister(RegisterSink registerSink) {

        MessageDTO<RegisterSink> messageDTO = new MessageDTO<>(registerSink,"Sink not found");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(registerSink.getSinkId());
        if(sinkExist.isPresent()) {

            Sink sink = sinkExist.get();
            //is it already bound ?
            if(sink.getUserId().equals("")) {

                messageDTO.setDescription("Sink is already unbounded");
            }
            else {

                sink.setUserId("");
                sink.setGreenhouseName("");
                sinkRepository.save(sink);

                log.info("Sink "+sink.getSinkId()+" unregistered from ClientID "+sink.getUserId());

                messageDTO.setDescription("Sink unregistered successfully");
            }
        }
        return messageDTO;
    }
}