package repository;

import domain.Sink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SinkRepository extends MongoRepository<Sink,String> {

    Optional<Sink> findBySerialId(String serialId);
}