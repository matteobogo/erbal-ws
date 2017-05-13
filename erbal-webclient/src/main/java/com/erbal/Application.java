package com.erbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableOAuth2Sso
public class Application {

//  /* CORS */
//  @Bean
//  public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurerAdapter() {
//
//      @Override
//      public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*");
//      }
//    };
//  }

  @RequestMapping(value = "/")
  public String welcome() {
    return "redirect:/index.html";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}