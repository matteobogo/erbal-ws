package repository;

import domain.TerrainSector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends MongoRepository<TerrainSector, String> {

    //custom queries
}