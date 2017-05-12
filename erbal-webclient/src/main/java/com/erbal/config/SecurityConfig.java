//package com.erbal.config;
//
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableOAuth2Sso
//@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//    httpSecurity
//            .antMatcher("/**")
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//            .antMatchers("/authentication/url").permitAll()
//            .antMatchers("/login**").authenticated()
//            .anyRequest().authenticated()
//            .and().csrf().disable();
//  }
//
//  @Override
//  public void configure(WebSecurity webSecurity) throws Exception {
//    webSecurity.ignoring().antMatchers("/ws**");
//  }
//}