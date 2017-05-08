package com.erbal.config;

import com.erbal.service.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  private TokenStore tokenStore = new InMemoryTokenStore(); //TODO TokenStore in DB ?

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CurrentUserDetailsService userDetailsService;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    // TODO persist clients details ?

    clients.inMemory()
            .withClient("erbal-collector")
            .secret("erbal-collector")
            .authorizedGrantTypes("client_credentials", "refresh_token")
            .scopes("server")
    .and()
            .withClient("erbal-greenhouse-management")
            .secret("erbal-greenhouse-management")
            .authorizedGrantTypes("client_credentials", "refresh_token")
            .scopes("server")
    .and()
            .withClient("erbal-notifier")
            .secret("erbal-notifier")
            .authorizedGrantTypes("client_credentials", "refresh_token")
            .scopes("server");
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
            .tokenStore(tokenStore)
            .authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
  }
}