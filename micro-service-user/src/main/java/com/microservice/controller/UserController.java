package com.microservice.controller;

import com.microservice.dao.UserRepository;
import com.microservice.entity.UserEntity;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zyf
 * @Description
 * @ClassName UserController
 * @Date 2022/2/28 14:50
 **/
@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}
