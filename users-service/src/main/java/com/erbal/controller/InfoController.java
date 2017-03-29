package com.erbal.controller;

import com.erbal.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/info")
public class InfoController {

    @RequestMapping(method = RequestMethod.GET)
    public User getUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setEmail(auth.getName());

        return user;
    }
}
