package com.erbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }

  /**
   * /me strategy return the principal authenticated with the system
   * associated to the token.
   *
   * @param principal
   * @return
   */
  @RequestMapping({ "/user", "/me" })
  public Map<String, String> user(Principal principal) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name", principal.getName());
    return map;
  }
}