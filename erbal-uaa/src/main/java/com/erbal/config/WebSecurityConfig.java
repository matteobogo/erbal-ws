package com.erbal.config;

import com.erbal.service.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CurrentUserDetailsService userDetailsService;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
  }







//  @Autowired
//  private CurrentUserDetailsService userDetailsService;

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//
//    http
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//            .antMatchers("/css/**").permitAll()
//            .antMatchers("/images/**").permitAll()
//            .antMatchers("/js/**").permitAll()
//            .antMatchers("/resources/**").permitAll()
//            .antMatchers("/oauth/**").authenticated()
//            .antMatchers("/j_spring_security_check").anonymous()
//            .antMatchers("/login/**").permitAll()
//            .antMatchers("/security-management/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin()
//            .loginPage("/login")
//            //.defaultSuccessUrl("/",true)
//            .usernameParameter("email")
//            .passwordParameter("password")
//            .and()
//            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
//            .and()
//            .exceptionHandling()
//            .accessDeniedPage("/access-denied")
//            .and().csrf().disable();
////
////            .deleteCookies("JSESSIONID")
////            .permitAll();
//  }

  /* Another Security Configuration with HTTP BasicAuth */
//  @Configuration
//  @Order(1)
//  public static class WebSecurityConfigBasicAuth extends WebSecurityConfigurerAdapter {
//
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//
//      httpSecurity
//              .authorizeRequests().anyRequest().authenticated()
//              .and()
//              .csrf().disable();
//    }
//  }
//
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web
//            .ignoring()
//            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//  }
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
////            .userDetailsService(userDetailsService)
////            .passwordEncoder(passwordEncoder());
//            .inMemoryAuthentication()
//            .withUser("admin")
//            .password("password")
//            .roles("ADMIN");
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Override
//  @Bean
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }
}