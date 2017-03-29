package com.erbal.service;

import com.erbal.domain.User;

import java.util.List;

public interface UserService {

    User add(User user);
    User edit(User user);
    List<User> findAll();
    User findOne(String id);
    User findByEmail(String email);
    User deleteById(String id);
}