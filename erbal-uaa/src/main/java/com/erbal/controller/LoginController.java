package com.erbal.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    /* user-info-endpoint */
    @RequestMapping(
            value = "/user/current",
            method = RequestMethod.GET
    )
    public Principal getUser(Principal principal) {

        return principal;
    }
}