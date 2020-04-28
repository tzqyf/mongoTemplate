package com.mongodb.demo.dao;

import com.mongodb.demo.entity.UserEntity;
import com.mongodb.demo.entity.UserEntityDO;

import java.util.List;

public interface UserDao {
    void saveUser(UserEntity user);

    UserEntity findOneById(Long id);


    List<UserEntity> findUserByPage(UserEntityDO userEntityDO);
}
