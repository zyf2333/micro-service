package com.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author zyf
 * @Description
 * @ClassName SecurityPermitAllConfig
 * @Date 2022/6/28 15:24
 **/
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/monitor/**").authenticated()
            .antMatchers("/actuator/**").authenticated()
            .anyRequest().permitAll()
            .and()
            .httpBasic()
            .and().csrf().disable();
    }
}
