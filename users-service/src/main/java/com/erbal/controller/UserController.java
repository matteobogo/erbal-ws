package com.erbal.controller;

import com.erbal.domain.User;
import com.erbal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    //TODO: http code response, validation, requestboy, exception handling of http errors, ecc...

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(
            @RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    public User edit(
            @RequestBody User user) {
        return userService.edit(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(String id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "/findByEmail", method = RequestMethod.GET)
    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteById(String id) {
        return userService.deleteById(id);
    }
}