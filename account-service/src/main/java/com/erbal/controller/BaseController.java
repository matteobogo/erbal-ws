package com.erbal.controller;

import com.erbal.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<T, ID extends Serializable> extends ExceptionHandler{

    protected BaseService<T, ID> service;

    protected BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public T add(T entity) {
        return service.add(entity);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseStatus(value = HttpStatus.OK)
    public T edit(T entity) {
        return service.edit(entity);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<T> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public T findOne(ID id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public T delete(T entity) {
        return service.delete(entity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public T deleteById(ID id) {
        return service.deleteById(id);
    }
}