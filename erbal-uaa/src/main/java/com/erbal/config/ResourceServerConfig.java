package com.erbal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
            .requestMatchers().antMatchers("/resources/**", "/user/current")
            .and().authorizeRequests()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

    resources.resourceId("erbal-uaa");
  }
}