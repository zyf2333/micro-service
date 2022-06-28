package com.microservice.controller;

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
    private RestTemplate restTemplate;

    @GetMapping("/users/{id}")
    public UserVO findById(@PathVariable Long id) {
        // 这里用到了RestTemplate的占位符能力
        UserVO user = this.restTemplate.getForObject("http://micro-service-user/users/{id}", UserVO.class, id);
        // ...电影微服务的业务...
        return user;
    }
}
