package repository;

import domain.Node;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodeRepository extends MongoRepository<Node,String> {

    Optional<Node> findBySerialId(String serialId);
}