package com.erbal;

import com.erbal.service.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;

@SpringBootApplication
@EnableDiscoveryClient
@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class Application {

  //user-info-endpoint
  @RequestMapping("/user/current")
  @ResponseBody
  public Principal user(Principal principal) {
    return principal;
  }

  //settings views to url
  @Configuration
  protected static class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/login").setViewName("login");
      registry.addViewController("/logout").setViewName("logout");
      registry.addViewController("/access-denied").setViewName("access-denied");
    }
  }

//  //Spring Security
//  @Configuration
//  @Order(-20)
//  protected static class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CurrentUserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {

//      http
//              .requestMatchers()
//              .antMatchers("/**")
//              .and()
//              .formLogin()
//              .loginPage("/login")
//              .usernameParameter("email")
//              .passwordParameter("password")
//              .permitAll()
//              .and()
//              .requestMatchers().antMatchers("/login/**").
//              .requestMatchers().antMatchers("/login/**", "/oauth/**", "/oauth/confirm_access","/user/current")
//              .and()
//              .authorizeRequests().anyRequest().authenticated()
//              .and().csrf().disable();

//          http
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
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      auth
//              .userDetailsService(userDetailsService)
//              .passwordEncoder(passwordEncoder());
////            .inMemoryAuthentication()
////              .withUser("admin")
////              .password("password")
////              .roles("ADMIN");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//      return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//      return super.authenticationManagerBean();
//    }
//  }
//
//  //OAuth Authorization Server
//  @Configuration
//  @EnableAuthorizationServer
//  protected static class OAuth2AuthorizationConfig extends
//          AuthorizationServerConfigurerAdapter {
//
//    private TokenStore tokenStore = new InMemoryTokenStore(); //TODO TokenStore in DB ?
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CurrentUserDetailsService userDetailsService;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//      clients.inMemory()
//              .withClient("erbal-gateway")
//              .secret("erbal-gateway")
//              .authorizedGrantTypes("authorization_code","refresh_token","password")
//              .scopes("browser")
//              .redirectUris("http://borgo.ddns.net:9999/");
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//      endpoints
//              .tokenStore(tokenStore)
//              .authenticationManager(authenticationManager)
//              .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
//            throws Exception {
//
//      oauthServer
//              .tokenKeyAccess("permitAll()")
//              .checkTokenAccess("isAuthenticated()");
//    }
//  }

//  @Configuration
//  @EnableResourceServer
//  protected static class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//
//      httpSecurity
//              .requestMatchers().antMatchers("/resources/**", "/user/current")
//              .and().authorizeRequests()
//              .antMatchers("/resources/**").permitAll()
//              .anyRequest().authenticated();
//    }
//  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}