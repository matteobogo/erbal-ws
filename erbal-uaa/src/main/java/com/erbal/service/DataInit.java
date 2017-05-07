package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.repository.UserRepository;
import com.erbal.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataInit {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public DataInit(
          UserRepository userRepository,
          PasswordEncoder passwordEncoder) {

    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    initDatabase();
  }

  private void initDatabase() {

    User userExist = userRepository.findByEmail("admin@erbal.com");

    if(userExist == null) {

      //admin
      User admin = new User();
      admin.setEmail("admin@erbal.com");

      if(passwordEncoder != null) {
        admin.setPasswordHash(passwordEncoder.encode("password"));
      }
      admin.setFirstname("pippo");
      admin.setLastname("pippi");
      admin.setGreenhouseName("IPASerra");
      List<String> roles = new ArrayList<>();
      roles.add(Roles.ROLE_ADMIN);
      admin.setRoles(roles);

      userRepository.save(admin);
    }
  }
}