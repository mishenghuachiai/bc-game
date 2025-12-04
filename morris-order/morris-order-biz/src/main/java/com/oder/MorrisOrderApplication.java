package com.oder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients(basePackages = {"com.user.api.facade"})
@SpringBootApplication
public class MorrisOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorrisOrderApplication.class, args);
    }
}
