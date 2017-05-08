package com.erbal.config;

import com.erbal.service.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CurrentUserDetailsService userDetailsService;

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//
//    http.
//            authorizeRequests()
//            .antMatchers("/").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/registration").permitAll()
//            .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//            .authenticated().and().csrf().disable().formLogin()
//            .loginPage("/login").failureUrl("/login?error=true")
//            .defaultSuccessUrl("/admin/home")
//            .usernameParameter("email")
//            .passwordParameter("password")
//            .and().logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/").and().exceptionHandling()
//            .accessDeniedPage("/access-denied");
//  }
//}

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
            .headers().disable()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/oauth/**").authenticated()
            .antMatchers("/j_spring_security_check").anonymous()
            .antMatchers("/login/**").anonymous()
            .antMatchers("/security-management/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .usernameParameter("email")
            .passwordParameter("password")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            .and()
            .exceptionHandling()
            .accessDeniedPage("/access-denied");
//
//            .deleteCookies("JSESSIONID")
//            .permitAll();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
//            .inMemoryAuthentication()
//            .withUser("admin")
//            .password("password")
//            .roles("ADMIN");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}