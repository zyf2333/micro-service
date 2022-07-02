package com.microservice.feignclient;

import com.microservice.config.UserFeignConfig;
import com.microservice.vo.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.Logger;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zyf
 * @Description
 * @ClassName UserFeignClient
 * @Date 2022/3/3 16:07
 **/
//@FeignClient(value = "micro-service-user", fallbackFactory = UserFeignClientFallbackFactory.class)
@FeignClient(value = "micro-service-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    UserVO findById(@PathVariable("id") Long id);

    @GetMapping("/users/test")
    UserVO test(@RequestParam Map<String,Object> map);

}
