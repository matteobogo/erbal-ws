package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.domain.dto.MessageDTO;

import java.util.List;

public interface UserService {

  MessageDTO<User> add(User user);
  MessageDTO<User> update(User user);
  MessageDTO<User> findById(String id);
  MessageDTO<User> findByEmail(String email);
  List<User> findAll();
  MessageDTO<User> deleteById(String id);
  MessageDTO<User> deleteByEmail(String email);
}