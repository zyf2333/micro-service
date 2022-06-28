package com.microservice.vo;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zyf
 * @Description
 * @ClassName UserVO
 * @Date 2022/2/28 15:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private BigDecimal balance;
}
