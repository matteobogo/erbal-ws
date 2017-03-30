package com.erbal.controller;

import com.erbal.domain.User;
import com.erbal.service.UserService;
import com.erbal.util.RestPreconditions;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/auth/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController extends ExceptionHandler {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public User add(
            @RequestBody User user) {
        Preconditions.checkNotNull(user);
        return userService.add(user);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User edit(
            @PathVariable String id,
            @RequestBody User user) {
        Preconditions.checkNotNull(user);
        RestPreconditions.checkFound(userService.findOne(id));
        return userService.edit(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User findById(
            @PathVariable String id) {
        return RestPreconditions.checkFound(userService.findOne(id));
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User findByEmail(
            @RequestBody String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public void deleteById(
            @PathVariable String id) {
        userService.deleteById(id);
    }
}