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

        User userExist = userRepository.findByEmail("mario.rossi@email.com");

        if(userExist == null) {
            //ADMIN
            User user = new User();
            user.setFirstname("Federico");
            user.setLastname("Errica");
            user.setEmail("f.errica@protonmail.com");
            user.setPasswordHash(passwordEncoder.encode("password"));
            user.setRole("ADMIN");

            userRepository.save(user);
        }
    }
}