package service;

import domain.Sink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SinkRepository;

import java.util.List;

@Service
public class SinkServiceImpl implements SinkService {

    private SinkRepository sinkRepository;

    @Autowired
    public SinkServiceImpl(SinkRepository sinkRepository) {
        this.sinkRepository = sinkRepository;
    }

    @Override
    public Sink add(Sink sink) {
        return null;
    }

    @Override
    public Sink update(Sink sink) {
        return null;
    }

    @Override
    public List<Sink> getAll() {
        return null;
    }

    @Override
    public Sink getSinkBySerialId(String serialId) {
        return null;
    }

    @Override
    public Sink deleteBySerialId(String serialId) {
        return null;
    }
}