package com.erbal.service;

import com.erbal.domain.dto.MessageDTO;

import java.util.List;

public interface CrudService<T> {

    MessageDTO<T> add(T entity);
    MessageDTO<T> update(T entity);
    List<T> getAll();
    MessageDTO<T> getEntityBySerialId(String serialId);
    MessageDTO<T> deleteEntityBySerialId(String serialId);
}