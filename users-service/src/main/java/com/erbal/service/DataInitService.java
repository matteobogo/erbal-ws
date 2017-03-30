package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Profile("testing")
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

        User user1 = userRepository.findByEmail("mario.rossi@email.com");
        User user2 = userRepository.findByEmail("f.errica@protonmail.com");

        if(user1 == null) {
            //ADMIN
            User user = new User(
                    "Federico",
                    "Errica",
                    "f.errica@protonmail.com",
                    "ADMIN");
            user.setPasswordHash(passwordEncoder.encode("password"));

            userRepository.save(user);
        }

        if(user2 == null) {
            //USER
            User user = new User(
                    "Mario",
                    "Rossi",
                    "mario.rossi@email.com",
                    "USER");
            user.setPasswordHash(passwordEncoder.encode("password"));

            userRepository.save(user);
        }
    }
}