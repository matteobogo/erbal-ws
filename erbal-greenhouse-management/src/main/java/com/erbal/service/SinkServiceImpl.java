package com.erbal.service;

import com.erbal.domain.Sink;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erbal.repository.SinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SinkServiceImpl implements CrudService<Sink> {

    private SinkRepository sinkRepository;

    @Autowired
    public SinkServiceImpl(SinkRepository sinkRepository) {
        this.sinkRepository = sinkRepository;
    }

    @Override
    public MessageDTO<Sink> add(Sink sink) {

        MessageDTO<Sink> message = new MessageDTO<>(null,"Sink already exist");
        Optional<Sink> sinkExist = sinkRepository.findBySinkId(sink.getSinkId());

        if(!sinkExist.isPresent()) {
            message.setEntity(sinkRepository.save(sink));
            message.setDescription("Sink added successfully");
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
        }
        return message;
    }
}