package com.service.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.NetworkInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * @param userName 用户名
     * @return 查询到的user记录
     */
    public List findByName(String userName) {
        UserExample ex = new UserExample();
        UserExample.Criteria criteria = ex.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userMapper.selectByExample(ex);
    }


    /**
     * @param user 用户信息
     * @return 返回插入后的主键
     */
    public int add(User user){



        userMapper.insertSelective(user);
        return user.getId();
    }


}
