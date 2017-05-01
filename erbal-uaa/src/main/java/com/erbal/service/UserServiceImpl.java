package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

  //logging
  private final Logger log = LoggerFactory.getLogger(getClass());

  //bcrypt
  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Autowired
  private UserRepository repository;

  @Override
  public void create(User user) {

    User existing = repository.findOne(user.getUsername());
    Assert.isNull(existing, "user already exists: " + user.getUsername());

    String hash = encoder.encode(user.getPassword());
    user.setPassword(hash);

    repository.save(user);

    log.info("new user has been created: {}", user.getUsername());
  }
}