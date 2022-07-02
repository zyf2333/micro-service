package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

//启用Hystrix断路器
@EnableCircuitBreaker
//启用feign
@EnableFeignClients
@SpringBootApplication
public class MicroServiceMovieFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceMovieFeignApplication.class, args);
    }

}
