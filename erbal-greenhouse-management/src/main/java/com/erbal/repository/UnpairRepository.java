package com.erbal.repository;

import com.erbal.domain.Pair;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnpairRepository extends MongoRepository<Pair,String> {
    //
}
