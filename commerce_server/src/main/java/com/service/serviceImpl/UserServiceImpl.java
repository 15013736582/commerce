package com.service.serviceImpl;

import com.mapper.UserMapper;
import com.pojo.Bvo;
import com.pojo.Role;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.UserService;
import com.util.CookieUtile;
import com.util.JwtUtil;
import com.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 **/
@Service
public class UserServiceImpl implements UserService {

    final private UserMapper userMapper;

    final private RoleServiceImpl roleService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RoleServiceImpl roleService) {
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    /**
     * @param user
     * @return
     */
    public Map login(User user) {
        Map<String, Object> result = new HashMap<>();
        user.setPassword(PasswordUtil.passwordCreate(user.getPassword()));
        List list = findByNameAndPassword(user);
        if (list.size() == 0) {
            result.put("state", 1);
            result.put("msg", "用户名或者密码错误");
            return result;
        }
        user = (User) list.get(0);
        Role role = roleService.findByUserId(user.getId());
        user.setPassword(null);
        result.put("state", 0);
        result.put("userInfo", user);
        result.put("type",role.getRoleType());
        Map<String, Object> claims = new HashMap<>();
        claims.put("userInfo",user);
        claims.put("type",role.getRoleType());
        try {
            String token =  JwtUtil.createJWT("0",claims,200*60*60*1000);
            CookieUtile.setCookie(token, user, String.valueOf(role.getRoleType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @param user 用户信息
     * @return 返回插入后的主键
     */
    public int add(User user) {
        user.setPassword(PasswordUtil.passwordCreate(user.getPassword()));
        user.setAddDate(new Date());
        userMapper.insertSelective(user);
        return user.getId();
    }

    /**
     * @param userName 用户名
     * @return 查询到的user记录
     */
    public List findByName(String userName) {
        UserExample ex = new UserExample();
        UserExample.Criteria criteria = ex.createCriteria();
        criteria.andUsernameEqualTo(userName);
        return userMapper.selectByExample(ex);
    }

    public List findByNameAndPassword(User user) {
        UserExample ex = new UserExample();
        UserExample.Criteria criteria = ex.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        return userMapper.selectByExample(ex);
    }

    public User findById(int userId){

       return userMapper.selectByPrimaryKey(userId);

    }
}
