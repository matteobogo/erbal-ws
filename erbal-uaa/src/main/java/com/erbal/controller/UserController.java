package com.erbal.controller;

import com.erbal.domain.User;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.service.UserService;
import com.erbal.utils.Roles;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/security-management/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {

    this.userService = userService;
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/add",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public MessageDTO<User> add(
          @RequestBody @Valid User user) {

    return userService.add(user);
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/update",
          method = RequestMethod.PUT,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<User> update(
          @RequestBody @Valid User user) {

    return userService.update(user);
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/{id}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<User> findById(@PathVariable("id") String id) {

    return userService.findById(id);
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/findByEmail/{email}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<User> findByEmail(@PathVariable("email") String email) {

    return userService.findByEmail(email);
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<User> findAll() {

    return userService.findAll();
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/delete/{id}",
          method = RequestMethod.DELETE
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<User> deleteById(@PathVariable("id") String id) {

    return userService.deleteById(id);
  }

  //@PreAuthorize(Roles.ROLE_ADMIN)
  @RequestMapping(
          value = "/deleteByEmail/{email}",
          method = RequestMethod.DELETE
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<User> deleteByEmail(@PathVariable("email") String email) {

    return userService.deleteByEmail(email);
  }

//  //@PreAuthorize("#oauth2.hasScope('server')")
//  @RequestMapping(
//          value = "/create",
//          method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
//  public void createUser(@Valid @RequestBody User user) {
//    userService.create(user);
//  }
}