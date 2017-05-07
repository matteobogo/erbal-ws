package com.erbal.controller;

import com.erbal.domain.User;
import com.erbal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  /* user-info-endpoint */
  @RequestMapping(value = "/current", method = RequestMethod.GET)
  public Principal getUser(Principal principal) {
    return principal;
  }

  //@PreAuthorize("#oauth2.hasScope('server')")
  @RequestMapping(
          value = "/create",
          method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public void createUser(@Valid @RequestBody User user) {
    userService.create(user);
  }
}