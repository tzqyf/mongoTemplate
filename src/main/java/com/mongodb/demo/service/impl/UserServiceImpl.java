package com.mongodb.demo.service.impl;

import com.mongodb.demo.dao.UserDao;
import com.mongodb.demo.entity.UserEntity;
import com.mongodb.demo.entity.UserEntityDO;
import com.mongodb.demo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void save(UserEntity user) {
        userDao.saveUser(user);
    }

    @Override
    public UserEntity findOne(Long id) {
        if(null == id){
            logger.info("id不能为空");
        }
        return userDao.findOneById(id);
    }

    @Override
    public List<UserEntity> findUserByPage(UserEntity userEntity, Integer pageSize, Integer currentPage) {
        UserEntityDO userEntityDO = new UserEntityDO();
        BeanUtils.copyProperties(userEntity,userEntityDO);
        userEntityDO.setCurrentPage(currentPage);
        userEntityDO.setPageSize(pageSize);
        List<UserEntity> userEntityList = userDao.findUserByPage(userEntityDO);
        return userEntityList;
    }
}
