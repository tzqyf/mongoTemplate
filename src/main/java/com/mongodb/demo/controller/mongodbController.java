package com.mongodb.demo.controller;

import com.mongodb.demo.entity.UserEntity;
import com.mongodb.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mongodb")
public class mongodbController {
    @Autowired
    private UserService userService;

    @RequestMapping("save")
    @ResponseBody
    public void save(Long a,String b){
        UserEntity user = new UserEntity();
        user.setId(a);
        user.setUserName("chongxie");
        user.setPassWord(b);
        userService.save(user);
    }

    @RequestMapping("findOne")
    @ResponseBody
    public void findOneById(){
        UserEntity userEntity = userService.findOne(100L);
        System.out.println(userEntity.toString());
    }

    @RequestMapping("fingByPage")
    @ResponseBody
    public void findByPage(int a,int b,String c){
        UserEntity user = new UserEntity();
        user.setUserName("c");
        user.setPassWord(c);
        List<UserEntity> userEntityList =  userService.findUserByPage(user,a,b);
        System.out.println(userEntityList.toString());
    }
}
