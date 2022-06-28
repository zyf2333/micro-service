package com.microservice.dao;

import com.microservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zyf
 * @Description
 * @ClassName UserRepository
 * @Date 2022/2/28 14:28
 **/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
