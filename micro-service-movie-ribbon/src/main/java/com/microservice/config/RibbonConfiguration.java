package com.microservice.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zyf
 * @Description
 * @ClassName RibbonConfiguration
 * @Date 2022/3/3 15:27
 **/
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        // 负载均衡规则，改为随机
//        return new RandomRule();
        //响应时间
        return new WeightedResponseTimeRule();
    }

}
