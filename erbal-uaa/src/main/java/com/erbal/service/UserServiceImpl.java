package com.erbal.service;

import com.erbal.domain.User;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MessageDTO<User> add(User user) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null, "User already exist");
        Optional<User> userExist = Optional.of(userRepository.findByEmail(user.getEmail()));

        if(!userExist.isPresent()) {

            //password encode
            user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

            messageDTO.setEntity(userRepository.save(user));
            messageDTO.setDescription("User added successfully");

            log.info("User "+user.getEmail()+" added");
        }
        return messageDTO;
    }

    @Override
    public MessageDTO<User> update(User user) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null,"User not exist");
        Optional<User> userExist = Optional.of(userRepository.findByEmail(user.getEmail()));

        if(userExist.isPresent()) {

            //password encode
            user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

            messageDTO.setEntity(userRepository.save(user));
            messageDTO.setDescription("User updated successfully");

            log.info("User "+user.getEmail()+" updated");
        }
        return messageDTO;
    }

    @Override
    public MessageDTO<User> findById(String id) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null,"User not exist");
        Optional<User> userExist = Optional.of(userRepository.findOne(id));

        if(userExist.isPresent()) {

            messageDTO.setEntity(userExist.get());
            messageDTO.setDescription("User retrieved successfully");
        }
        return messageDTO;
    }

    @Override
    public MessageDTO<User> findByEmail(String email) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null,"User not exist");
        Optional<User> userExist = Optional.of(userRepository.findByEmail(email));

        if(userExist.isPresent()) {

            messageDTO.setEntity(userExist.get());
            messageDTO.setDescription("User retrieved successfully");
        }
        return messageDTO;
    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public MessageDTO<User> deleteById(String id) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null,"User not exist");
        Optional<User> userExist = Optional.of(userRepository.findOne(id));

        if(userExist.isPresent()) {

            userRepository.delete(id);
            messageDTO.setEntity(userExist.get());
            messageDTO.setDescription("User deleted successfully");

            log.info("User "+userExist.get().getEmail()+" deleted");
        }
        return messageDTO;
    }

    @Override
    public MessageDTO<User> deleteByEmail(String email) {

        MessageDTO<User> messageDTO = new MessageDTO<>(null,"User not exist");
        Optional<User> userExist = Optional.of(userRepository.findByEmail(email));

        if(userExist.isPresent()) {

            userRepository.delete(userExist.get().getId());
            messageDTO.setEntity(userExist.get());
            messageDTO.setDescription("User deleted successfully");

            log.info("User "+userExist.get().getEmail()+" deleted");
        }
        return messageDTO;
    }
}