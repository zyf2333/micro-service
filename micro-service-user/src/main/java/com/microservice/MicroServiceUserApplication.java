package com.microservice;

import com.microservice.dao.UserRepository;
import com.microservice.entity.UserEntity;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.*"})
public class MicroServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceUserApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository) {
        return args -> {
            UserEntity user1 = new UserEntity(1L, "account1", "张三", 20, new BigDecimal(100.00));
            UserEntity user2 = new UserEntity(2L, "account2", "李四", 28, new BigDecimal(180.00));
            UserEntity user3 = new UserEntity(3L, "account3", "王五", 32, new BigDecimal(280.00));
            Stream.of(user1, user2, user3).forEach(userRepository::save);
        };
    }
}
