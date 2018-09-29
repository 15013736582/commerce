package com.service.serviceImpl;

import com.mapper.RoleMapper;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 19:07
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    public void add(Role role){
        roleMapper.insertSelective(role);
    }
}
