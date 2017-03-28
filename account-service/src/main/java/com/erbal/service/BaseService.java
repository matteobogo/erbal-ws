package com.erbal.service;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseService<T, ID extends Serializable> {

    protected Repository<T, ID> repository;

    protected BaseService(Repository<T,ID> repository) {
        this.repository = repository;
    }

    public T add(T entity) {
        //TODO con Optional<T> and isPresente()
        return null;
    }

    public T edit(T entity) {
        //TODO
        return null;
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