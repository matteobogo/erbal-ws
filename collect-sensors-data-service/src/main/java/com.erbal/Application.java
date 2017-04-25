package com.erbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableResourceServer
@EnableDiscoveryClient
//@EnableOAuth2Client
@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableConfigurationProperties
//@Configuration
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}