package com.erbal.service;

import com.erbal.domain.Node;
import com.erbal.domain.Sink;
import com.erbal.domain.dto.*;
import com.erbal.exception.AlreadyRegisteredException;
import com.erbal.exception.AlreadyUnregisteredException;
import com.erbal.repository.NodeRepository;
import domain.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.SinkRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
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
            sinkTable = new SinkTable(sinkId,sink.get().getGreenhouseName(),nodes);
        }
        return sinkTable;
    }

    @Override
    public List<Sink> findAllByUserId(String userId) {

        return sinkRepository.findAllByUserId(userId);
    }

    @Override
    public MessageDTO<RegisterSink> register(RegisterSink registerSink)
            throws AlreadyRegisteredException, EntityNotFoundException {

        MessageDTO<RegisterSink> result;

        Optional<Sink> sinkExist = sinkRepository.findBySinkId(registerSink.getSinkId());
        if(sinkExist.isPresent()) {

            Sink sink = sinkExist.get();
            //is it already bound ?
            if(sink.getUserId().equals("")) {

                sink.setUserId(registerSink.getUserId());
                sink.setGreenhouseName(registerSink.getGreenhouseName());

                sinkRepository.save(sink);

                result = new MessageDTO<>(registerSink,"Sink registered successfully");

                log.info("Sink "+sink.getSinkId()+" registered with ClientID "+sink.getUserId());
            }
            else throw new AlreadyRegisteredException();
        }
        else throw new EntityNotFoundException();

        return result;
    }

    @Override
    public MessageDTO<RegisterSink> unregister(RegisterSink registerSink)
            throws AlreadyUnregisteredException, EntityNotFoundException {

        MessageDTO<RegisterSink> result;

        Optional<Sink> sinkExist = sinkRepository.findBySinkId(registerSink.getSinkId());
        if(sinkExist.isPresent()) {

            Sink sink = sinkExist.get();
            //is it already bound ?
            if(sink.getUserId().equals("")) {

                sink.setUserId("");
                sink.setGreenhouseName("");

                sinkRepository.save(sink);

                result = new MessageDTO<>(registerSink,"Sink unregistered successfully");

                log.info("Sink "+sink.getSinkId()+" unregistered from ClientID "+sink.getUserId());
            }
            else throw new AlreadyUnregisteredException();
        }
        else throw new EntityNotFoundException();

        return result;
    }

    @Override
    public List<SinkTable> findAllSinkWithNodesByUserId(String userId) {

        List<SinkTable> sinkTables = new ArrayList<>();

        //obtain all sinks from userId
        List<Sink> sinkList = sinkRepository.findAllByUserId(userId);

        sinkList.forEach(s -> {
                    List<Node> nodeList = nodeRepository.findAllBySink(s);
                    sinkTables.add(new SinkTable(s.getSinkId(),s.getGreenhouseName(),nodeList));
                });
        return sinkTables;
    }

    @Override
    public List<SinkPreview> findAllSinkPreview(String userId) {

        //obtain sink list from userId from Greenhouse Management Service
        List<Sink> sinkList = sinkRepository.findAllByUserId(userId);

        log.info("Retrieved Sink List ["+sinkList.size()+"] from Greenhouse Service by UserID "+userId);

        List<SinkPreview> sinkPreviewList = new ArrayList<>();

        sinkList.stream()
                .sorted(Comparator.comparing(Sink::getGreenhouseName))
                .forEach(e -> sinkPreviewList.add(new SinkPreview(e.getSinkId(), e.getGreenhouseName())));

        return sinkPreviewList;
    }
}