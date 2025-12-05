package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
public class MorrisUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorrisUserApplication.class, args);
    }
}
