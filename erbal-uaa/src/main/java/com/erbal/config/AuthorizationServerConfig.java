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

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  private TokenStore tokenStore = new InMemoryTokenStore();

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CurrentUserDetailsService userDetailsService;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    clients.inMemory()

            .withClient("erbal-gateway")
            .secret("erbal-gateway")
            .authorizedGrantTypes("refresh_token", "authorization_code")
            //.authorities("ADMIN")
            .scopes("read","write")
            //.redirectUris("http://borgo.ddns.net:9999/home")
            .accessTokenValiditySeconds(Integer.MAX_VALUE)
            .autoApprove(true);
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
            //.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
  }
}






//  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//    endpoints
//            .tokenStore(tokenStore)
//            .authenticationManager(authenticationManager)
//            .userDetailsService(userDetailsService);
//  }
//
//  @Override
//  public void configure(AuthorizationServerSecurityConfigurer oauthServer)
//          throws Exception {
//    oauthServer
//            .tokenKeyAccess("permitAll()")
//            .checkTokenAccess("isAuthenticated()");
//  }

//  @Override
//  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//    clients.inMemory()
//
//            //erbal-gateway (where web client is located)
//            .withClient("erbal-gateway")
//            .secret("erbal-gateway")
//            .authorizedGrantTypes("authorization_code", "refresh_token")
//            //.authorities("USER","ADMIN")
//            .scopes("read","write")
//            .autoApprove(true);

//    clients.inMemory()
//            .withClient("ui1")
//            .secret("ui1-secret")
//            .authorities("ROLE_TRUSTED_CLIENT")
//            .authorizedGrantTypes("authorization_code", "refresh_token")
//            .scopes("ui1.read")
//            .autoApprove(true)
//            .and()
//            .withClient("ui2")
//            .secret("ui2-secret")
//            .authorities("ROLE_TRUSTED_CLIENT")
//            .authorizedGrantTypes("authorization_code", "refresh_token")
//            .scopes("ui2.read", "ui2.write")
//            .autoApprove(true)
//            .and()
//            .withClient("mobile-app")
//            .authorities("ROLE_CLIENT")
//            .authorizedGrantTypes("implicit", "refresh_token")
//            .scopes("read")
//            .autoApprove(true)
//            .and()
//            .withClient("customer-integration-system")
//            .secret("1234567890")
//            .authorities("ROLE_CLIENT")
//            .authorizedGrantTypes("client_credentials")
//            .scopes("read")
//            .autoApprove(true);
//  }
//}






//  @Autowired
//  private CurrentUserDetailsService userDetailsService;

//  @Override
//  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//    endpoints.authenticationManager(authenticationManager);
//  }
//
//  @Override
//  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    // TODO persist clients details ?

//    clients.inMemory()
//            .withClient("erbal-collector")
//            .secret("erbal-collector")
//            .authorizedGrantTypes("client_credentials", "refresh_token")
//            .scopes("server")
//    .and()
//            .withClient("erbal-greenhouse-management")
//            .secret("erbal-greenhouse-management")
//            .authorizedGrantTypes("client_credentials", "refresh_token")
//            .scopes("server")
//    .and()
//            .withClient("erbal-notifier")
//            .secret("erbal-notifier")
//            .authorizedGrantTypes("client_credentials", "refresh_token")
//            .scopes("server");

//    clients.inMemory()
//
//            //erbal-gateway (where web client is located)
//            .withClient("erbal-gateway")
//            .secret("erbal-gateway")
//            .authorizedGrantTypes("authorization_code", "refresh_token", "implicit")
//            .authorities("USER","ADMIN")
//            .scopes("read","write")
//            .autoApprove(false);


//              .withClient("erbal-webclient")
//              .secret("erbal-webclient")
//              .resourceIds("erbal-uaa")
//              .scopes("read,write")
//              .authorizedGrantTypes("authorization_code","password","refresh_token")
//              //.redirectUris("http://borgo.ddns.net:8080/")
//              .authorities("ROLE_CLIENT")
//              .accessTokenValiditySeconds(Integer.MAX_VALUE)
//              .refreshTokenValiditySeconds(Integer.MAX_VALUE)
//              .additionalInformation("")
//              .autoApprove(true)

//              .and()
//              .withClient("erbal-greenhouse-management")
//              .secret("erbal-greenhouse-management")
//              .authorizedGrantTypes("client_credentials", "refresh_token")
//              .scopes("server");

//  }

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