package com.mongodb.demo.service;

import com.mongodb.demo.entity.UserEntity;

import java.util.List;

public interface UserService {
    void save(UserEntity user);

    UserEntity findOne(Long id);

    List<UserEntity> findUserByPage(UserEntity userEntity,Integer pageSize,Integer currentPage);
}

