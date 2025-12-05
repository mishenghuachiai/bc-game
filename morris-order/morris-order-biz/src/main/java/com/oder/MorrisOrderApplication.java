package com.oder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.user.api.facade"})
@SpringBootApplication
@PropertySource(value = {"api-application.properties"})
public class MorrisOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorrisOrderApplication.class, args);
    }
}
