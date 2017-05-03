package repository;

import domain.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodeRepository extends CrudRepository<Node,String> {

    Optional<Node> findBySerialId(String serialId);
}