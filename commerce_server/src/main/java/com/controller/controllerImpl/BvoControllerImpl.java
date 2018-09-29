package com.controller.controllerImpl;

import com.controller.BvoController;
import com.pojo.Bvo;
import com.pojo.Role;
import com.pojo.User;
import com.service.serviceImpl.BvoServiceImpl;
import com.service.serviceImpl.RoleServiceImpl;
import com.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 18:09
 **/
@RestController
@RequestMapping("api/bvo/bvo")
public class BvoControllerImpl implements BvoController {

    final
    BvoServiceImpl bovService;

    final
    UserServiceImpl userService;

    final
    RoleServiceImpl roleService;

    @Autowired
    public BvoControllerImpl(BvoServiceImpl bovService, UserServiceImpl userService, RoleServiceImpl roleService) {
        this.bovService = bovService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping("register")
    public Map register(User user, Bvo bvo){
        Map<String, Object> result = new HashMap<>();
        bovService.register(user,bvo);
        return result;
    }

}
