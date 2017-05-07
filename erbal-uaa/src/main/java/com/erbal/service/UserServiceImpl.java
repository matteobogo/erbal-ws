//package com.erbal.service;
//
//import com.erbal.domain.User;
//import com.erbal.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//  private final Logger log = LoggerFactory.getLogger(getClass());
//
//  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//  private UserRepository userRepository;
//
//  @Autowired
//  public UserServiceImpl(UserRepository userRepository) {
//
//    this.userRepository = userRepository;
//  }
//
//  @Override
//  public void create(User user) {
//
//    User userExist = userRepository.findOne(user.getUsername());
//    Assert.isNull(userExist, "user already exists: " + user.getUsername());
//
//    //encode password
//    String hash = encoder.encode(user.getPassword());
//    user.setPasswordHash(hash);
//
//    userRepository.save(user);
//
//    log.info("User has been created: ", user.getUsername());
//  }
//}