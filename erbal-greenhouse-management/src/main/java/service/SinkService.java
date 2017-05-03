package service;

import domain.Sink;

import java.util.List;

public interface SinkService {

    Sink add(Sink sink);
    Sink update(Sink sink);
    List<Sink> getAll();
    Sink getSinkBySerialId(String serialId);
    Sink deleteBySerialId(String serialId);
}