package com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RedisConditionConfig {
    @Bean
    public String redisDemoBean(){
        return "RedisTemplate is exist";
    }

}
