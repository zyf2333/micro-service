package com.microservice.controller;

import com.microservice.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping("/movies")
@RestController
public class MovieController {

//    @Autowired
//    private RestTemplate restTemplate;
    private static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/users/{id}")
    public UserVO findById(@PathVariable Long id) {
        log.info("findById:{}",id);
        // 这里用到了RestTemplate的占位符能力
        UserVO user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", UserVO.class, id);
        // ...电影微服务的业务...
        return user;
    }
}
