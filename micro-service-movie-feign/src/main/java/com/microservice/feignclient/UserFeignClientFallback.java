package com.microservice.feignclient;

import com.microservice.vo.UserVO;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @Author zyf
 * @Description
 * @ClassName UserFeignClientFallback
 * @Date 2022/6/30 22:42
 **/
@Component
public class UserFeignClientFallback implements UserFeignClient{

    @Override
    public UserVO findById(Long id) {
        return new UserVO(id, "默认用户", "默认用户", 2, new BigDecimal(1),"断路");
    }

    @Override
    public UserVO test(Map<String, Object> map) {
        return new UserVO(1l, "默认用户", "默认用户", 2, new BigDecimal(1),"断路");
    }
}
