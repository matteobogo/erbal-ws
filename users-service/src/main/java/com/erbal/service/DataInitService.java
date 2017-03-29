package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataInitService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        populateDb();
    }

    private void populateDb() {

        User userExist = userRepository.findByEmail("mario.rossi@email.com");

        if(userExist == null) {
            //ADMIN
            User user = new User();
            user.setFirstname("Mario");
            user.setLastname("Rossi");
            user.setEmail("mario.rossi@email.com");
            user.setPasswordHash(passwordEncoder.encode("password"));
            user.setRole("ADMIN");

            userRepository.save(user);
        }
    }
}
