package com.erbal.service;

import domain.dto.MessageDTO;

import java.util.List;

public interface CrudService<T> {

    MessageDTO<T> add(T entity);
    MessageDTO<T> update(T entity);
    List<T> getAll();
    MessageDTO<T> getEntityBySerialId(String serialId);
    MessageDTO<T> deleteEntityBySerialId(String serialId);
}