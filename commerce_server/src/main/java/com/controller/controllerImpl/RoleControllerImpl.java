package com.controller.controllerImpl;

import com.controller.RoleController;
import com.pojo.Role;
import com.service.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-30 15:02
 **/
@RestController
@RequestMapping("api/role")
public class RoleControllerImpl implements RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @RequestMapping("test")
    public int test(){
        Role role = new Role();
        role.setUserId(1);
        role.setUserInfoId(2);
        role.setRoleType(0);
        roleService.add(role);
        return role.getId();
    }

}
