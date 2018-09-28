package com.service.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-27 13:00
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public Map find(User user){
        Map<String, Object> result = new HashMap<>();
        user.setUserName("!");
        userMapper.insertSelective(user);
        return result;
    }
}
