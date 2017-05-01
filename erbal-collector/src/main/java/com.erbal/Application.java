package com.erbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@EnableResourceServer
@EnableDiscoveryClient
//@EnableOAuth2Client
//@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableConfigurationProperties
//@Configuration
@Controller
public class Application {

    /* CORS */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/collect")
                        .allowedOrigins("*");
            }
        };
    }

    @RequestMapping(value = "/")
    public String welcome() {
        return "redirect:/welcome.html";
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}