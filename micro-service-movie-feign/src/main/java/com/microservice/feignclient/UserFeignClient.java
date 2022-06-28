package com.microservice.feignclient;

import com.microservice.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zyf
 * @Description
 * @ClassName UserFeignClient
 * @Date 2022/3/3 16:07
 **/
@FeignClient(name = "micro-service-user")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    UserVO findById(@PathVariable("id") Long id);

}
