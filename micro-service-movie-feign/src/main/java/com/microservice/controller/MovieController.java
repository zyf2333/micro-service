package com.microservice.controller;

import com.microservice.entity.UserEntity;
import com.microservice.feignclient.UserFeignClient;
import com.microservice.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ServerWebExchange;

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

    @Autowired
    private UserFeignClient userFeignClient;

//    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public UserVO findById(@PathVariable Long id) {
        UserVO user = userFeignClient.findById(id);
        // ...电影微服务的业务...
        return user;
    }

    @GetMapping("/test")
    public UserVO test(UserVO userVO) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", userVO.getId());
        map.put("username", userVO.getUsername());
        return userFeignClient.test(map);
    }

    public UserVO findByIdFallback(Long id) {
        System.out.println(RequestContextHolder.getRequestAttributes());
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());
//        log.error("接口调用失败，进入回退方法，URL={}", request.getPath().pathWithinApplication().value());
        return new UserVO(id, "默认用户", "默认用户", 0, new BigDecimal(1),"断路");
    }
}
