package com.microservice.config;

import feign.Logger;
import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zyf
 * @Description
 * @ClassName UserFeignConfig
 * @Date 2022/6/29 17:26
 **/
@Configuration
public class UserFeignConfig {

    @Bean
    public Logger.Level loggerLevel() {
        return Level.FULL;
    }

}
