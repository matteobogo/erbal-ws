package com.erbal.controller;

import com.erbal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

//  private UserService userService;
//
//  @Autowired
//  public LoginController(UserService userService) {
//
//    this.userService = userService;
//  }

//  @RequestMapping(
//          value={"/", "/login"},
//          method = RequestMethod.GET
//  )
//  @ResponseBody
//  public ModelAndView login(){
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("login");
//    return modelAndView;
//  }
}