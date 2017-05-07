//package com.erbal.config;
//
//import com.erbal.service.MongoUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//
//  private TokenStore tokenStore = new InMemoryTokenStore(); //TODO sostituisci con tokenstore su db ?
//
//  @Autowired
//  //@Qualifier("authenticationManagerBean")
//  private AuthenticationManager authenticationManager;
//
//  @Autowired
//  private MongoUserDetailsService userDetailsService;
//
//  @Autowired
//  private Environment env;
//
//  @Override
//  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//    // TODO persist clients details
//
//    clients.inMemory()
//            .withClient("erbal-collector")
//            .secret("erbal-collector")
//            //.secret(env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
//            .authorizedGrantTypes("client_credentials", "refresh_token")
//            .scopes("server");
//
//    // @formatter:off
////    clients.inMemory()
////            .withClient("browser")
////            .authorizedGrantTypes("refresh_token", "password")
////            .scopes("ui")
////            .and()
////            .withClient("account-com.erbal.service")
////            .secret(env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
////            .authorizedGrantTypes("client_credentials", "refresh_token")
////            .scopes("server")
////            .and()
////            .withClient("statistics-com.erbal.service")
////            .secret(env.getProperty("STATISTICS_SERVICE_PASSWORD"))
////            .authorizedGrantTypes("client_credentials", "refresh_token")
////            .scopes("server")
////            .and()
////            .withClient("notification-com.erbal.service")
////            .secret(env.getProperty("NOTIFICATION_SERVICE_PASSWORD"))
////            .authorizedGrantTypes("client_credentials", "refresh_token")
////            .scopes("server");
////    // @formatter:on
//  }
//
//  @Override
//  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//    endpoints
//            .tokenStore(tokenStore)
//            .authenticationManager(authenticationManager)
//            .userDetailsService(userDetailsService);
//  }
//
//  @Override
//  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//    oauthServer
//            .tokenKeyAccess("permitAll()")
//            .checkTokenAccess("isAuthenticated()");
//  }
//}