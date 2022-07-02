package com.microservice.controller;

import com.microservice.dao.UserRepository;
import com.microservice.entity.UserEntity;
import com.microservice.vo.UserVO;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private Environment environment;

    public String getPort() {
        return environment.getProperty("local.server.port");
    }


    @GetMapping("/{id}")
    public UserVO findById(@PathVariable Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userEntity.get(), userVO);
            userVO.setServerPort(getPort());
            return userVO;
        }
        return null;
    }

    @GetMapping("/test")
    public UserVO test(UserVO map){
        return map;
    }


}
