package com.erbal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@Controller
public class Application {

    @RequestMapping(value = "/")
    public String welcome() {
        return "redirect:/welcome.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}