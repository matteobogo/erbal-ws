//package com.erbal.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
//
//@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@EnableOAuth2Sso
//public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//  OAuth2RestTemplate restTemplate;
//
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web.ignoring().antMatchers("/ws**");
//  }
//
//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//    httpSecurity
//            //.antMatcher("/**")
//            //.authorizeRequests()
//            //.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
////            .authorizeRequests()
////            .antMatchers("/").permitAll()
////            .anyRequest().fullyAuthenticated()
////            .and()
////            .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
////            .and()
////            .logout().permitAll()
////            .and()
////            .csrf().disable();
//
//            .antMatcher("/**")
//            .authorizeRequests()
//            .antMatchers("/index.html", "/home.html", "/").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .csrf().disable();
//  }
//
//  /**
//   * Gateway with UI Application can refresh expired access token automatically
//   *
//   * @param oauth2ClientContext
//   * @param details
//   * @return
//   */
//  @Bean
//  public OAuth2RestTemplate oauth2RestTemplate(
//          OAuth2ClientContext oauth2ClientContext,
//          OAuth2ProtectedResourceDetails details) {
//
//    return new OAuth2RestTemplate(details, oauth2ClientContext);
//  }
//}