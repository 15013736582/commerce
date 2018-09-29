package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-27 13:00
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void  add(){
        User user = new User();
        user.setUserName("!");
        userMapper.insertSelective(user);
    }
}
