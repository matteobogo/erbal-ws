package com.erbal.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<T, ID extends Serializable> {

    protected CrudRepository<T, ID> repository;

    protected BaseService(CrudRepository<T,ID> repository) {
        this.repository = repository;
    }

    public T add(T entity) {
        //TODO con Optional<T> and isPresente()
        //TODO check su auth service l'utente
        return repository.save(entity);
    }

    public T edit(T entity) {
        //TODO
        return repository.save(entity);
    }

    public List<T> findAll() {
        //TODO
        return null;
    }

    public T findOne(ID id) {
        //TODO
        return null;
    }

    public T delete(T entity) {
        //TODO
        return null;
    }

    public T deleteById(ID id) {
        //TODO
        return null;
    }
}