package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.MvoMapper;
import com.pojo.Mvo;
import com.pojo.MvoExample;
import com.pojo.Role;
import com.pojo.User;
import com.service.MvoService;
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


    /**
     * @param user user信息
     * @param mvo  mov信息
     * @return  Map state,
     */
    public Map register(User user,Mvo mvo){
        Map<String, Object> result = new HashMap<>();
        List userList = userService.findByName(user.getUsername());
        if (!userList.isEmpty()) {
            result.put("state",ResultState.Fail.getState());
            result.put("mes","用户名已存在");
            return result;
        }
        userService.add(user);
        Role role = new Role();
        role.setUserId(user.getId());
        role.setUserInfoId(add(mvo));
        role.setRoleType(1);
        roleService.add(role);
        result.put("state",0);
        return result;
    }

    /**
     * @param mvo
     * @return  map.state状态
     */
    public Map updata(Mvo mvo){
        Map<String, Object> result = new HashMap<>();
        mvoMapper.updateByPrimaryKey(mvo);
        result.put("state", ResultState.SECCESS.getState());
        return  result;
    }

    /**
     * @param mov
     * @return 插入后的主键
     */
    public int add(Mvo mov){
        mvoMapper.insertSelective(mov);
        return  mov.getId();
    }

    public Mvo findById(int id){
        return mvoMapper.selectByPrimaryKey(id);
    }

    public Map findByUserId(int userId){
        Map<String, Object> result = new HashMap<>();
        Role role = roleService.findByUserId(userId);
        result.put("state",ResultState.SECCESS.getState());
        result.put("mvoInfo",findById(role.getUserInfoId()));
        return result;
    }
}
