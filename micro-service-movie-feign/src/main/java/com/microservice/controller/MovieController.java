package com.microservice.controller;

import com.microservice.feignclient.UserFeignClient;
import com.microservice.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zyf
 * @Description
 * @ClassName MovieController
 * @Date 2022/2/28 15:21
 **/
@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public UserVO findById(@PathVariable Long id) {

        UserVO user = userFeignClient.findById(id);
        // ...电影微服务的业务...
        return user;
    }
}
