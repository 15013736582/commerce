package com.service.serviceImpl;

import com.mapper.BvoMapper;
import com.pojo.Bvo;
import com.pojo.Role;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.text.normalizer.UBiDiProps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 18:13
 **/
@Service
public class BvoServiceImpl {

    private final RoleServiceImpl roleService;

    private final UserServiceImpl userService;

    private final BvoMapper bvoMapper;

    @Autowired
    public BvoServiceImpl(RoleServiceImpl roleService, UserServiceImpl userService, BvoMapper bvoMapper) {
        this.roleService = roleService;
        this.userService = userService;
        this.bvoMapper = bvoMapper;
    }

    /**
     * @param user user信息
     * @param bvo  bov信息
     * @return  Map state,
     */
    public Map register(User user, Bvo bvo){
        Map<String, Object> result = new HashMap<>();
        List userList = userService.findByName(user.getUsername());
        if (!userList.isEmpty()) {
            result.put("state",1);
            result.put("mes","用户名已存在");
            return result;
        }
        userService.add(user);
        Role role = new Role();
        role.setUserId(user.getId());
        role.setUserInfoId(add(bvo));
        role.setRoleType(2);
        roleService.add(role);
        result.put("state",0);
        return result;
    }

    /**
     * @param bvo 借卖商信息
     * @return 返回插入后的主键
     */
    public int add(Bvo bvo){
        bvoMapper.insertSelective(bvo);
        return bvo.getId();
    }

    /**
     * @param id bvoid
     * @return Bvo对象
     */
    public Bvo findById(int id){
        return bvoMapper.selectByPrimaryKey(id);
    }
}
