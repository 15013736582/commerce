package com.service.serviceImpl;

import com.mapper.MvoMapper;
import com.pojo.Mvo;
import com.pojo.Role;
import com.pojo.User;
import com.service.MvoService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 20:11
 **/
@Service
public class MvoServiceImpl implements MvoService {
    private final MvoMapper mvoMapper;

    private final UserServiceImpl userService;

    private final RoleServiceImpl roleService;

    @Autowired
    public MvoServiceImpl(MvoMapper mvoMapper, UserServiceImpl userService, RoleServiceImpl roleService) {
        this.mvoMapper = mvoMapper;
        this.userService = userService;
        this.roleService = roleService;
    }

    public int add(Mvo mov ){
        return  mvoMapper.insertSelective(mov);
    }

    public Map register(User user,Mvo mvo){
        Map<String, Object> result = new HashMap<>();
        List userList = userService.findByName(user.getUserName());
        if (!userList.isEmpty()) {
            result.put("state",1);
            result.put("mes","用户名已存在");
            return result;
        }
        user.setId(userService.add(user));
        mvo.setId(add(mvo));
        Role role = new Role();
        role.setUserId(user.getId());
        role.setUserInfoId(mvo.getId());
        role.setRoleType(1);
        roleService.add(role);
        result.put("state",0);
        return result;
    }
}
