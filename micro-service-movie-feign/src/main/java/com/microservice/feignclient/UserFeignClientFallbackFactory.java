package com.microservice.feignclient;

import com.microservice.vo.UserVO;
import feign.hystrix.FallbackFactory;
import java.math.BigDecimal;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author zyf
 * @Description
 * @ClassName UserFeignClientFallbackFactory
 * @Date 2022/6/30 18:45
 **/
@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public UserVO findById(Long id) {
                log.info("factory");
//                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//                System.out.println(request.getRequestURI());
//                System.out.println(request.getRequestURL());
//                log.error("接口调用失败，进入回退方法，URL={}", request.getPath().pathWithinApplication().value());
                return new UserVO(id, "默认用户", "默认用户", 2, new BigDecimal(1),"断路");
            }

            @Override
            public UserVO test(Map<String, Object> map) {
                return null;
            }
        };
    }
}
