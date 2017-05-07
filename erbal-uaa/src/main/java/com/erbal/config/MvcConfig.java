package com.erbal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    registry.addViewController("/").setViewName("home");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/logout").setViewName("logout");
    registry.addViewController("/access-denied").setViewName("access-denied");

//    registry.addViewController("/home").setViewName("home");
//    registry.addViewController("/").setViewName("home");
//    registry.addViewController("/hello").setViewName("hello");
//    registry.addViewController("/login").setViewName("login");
//    registry.addViewController("/admin/home").setViewName("admin");
  }
}