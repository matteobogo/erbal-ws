package repository;

import domain.Sink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SinkRepository extends CrudRepository<Sink,String> {

    Optional<Sink> findBySerialId(String serialId);
}