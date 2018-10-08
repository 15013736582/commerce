package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.BvoMapper;
import com.mapper.BvoOrderMapper;
import com.mapper.StoreMapper;
import com.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private final StoreMapper storeMapper;
    private final BvoOrderMapper broOrderMapper;

    @Autowired
    public BvoServiceImpl(RoleServiceImpl roleService, UserServiceImpl userService, BvoMapper bvoMapper, StoreMapper storeMapper, BvoOrderMapper broOrderMapper1) {
        this.roleService = roleService;
        this.userService = userService;
        this.bvoMapper = bvoMapper;
        this.storeMapper = storeMapper;
        this.broOrderMapper = broOrderMapper1;
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

    public  Map update(Bvo bvo){
        Map<String,Object> result=new HashMap<>();
//        自动找bvo中主键
        bvoMapper.updateByPrimaryKey(bvo);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }

    public  Map findByUserId(int userId){
        Map<String,Object> result=new HashMap<>();
        Role role=roleService.findByUserId(userId);
        result.put("state",ResultState.SECCESS.getState());
        result.put("bvoInfo",findById(role.getUserInfoId()));
        result.put("username",userService.findById(userId).getUsername());
        return  result;
    }

    public Map findStore(int bid){
        Map<String,Object> result=new HashMap<>();
        StoreExample ex=new StoreExample();
        StoreExample.Criteria criteria=ex.createCriteria();
        criteria.andBIdEqualTo(bid);
//        criteria.andPlatformEqualTo(platform);
         storeMapper.selectByExample(ex);
         result.put("store",storeMapper.selectByExample(ex));
         return result;
    }

    public Map addStore(Store store){
        Map<String,Object> result=new HashMap<>();
        StoreExample ex=new StoreExample();
        StoreExample.Criteria criteria=ex.createCriteria();
        criteria.andPlatformEqualTo(store.getPlatform());
        criteria.andBIdEqualTo(store.getbId());
        criteria.andNameEqualTo(store.getName());
        result.put("state",ResultState.SECCESS.getState());
        result.put("store",storeMapper.insertSelective(store));
        return  result;

    }


}
