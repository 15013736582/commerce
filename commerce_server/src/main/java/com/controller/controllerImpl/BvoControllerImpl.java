package com.controller.controllerImpl;

import com.controller.BvoController;
import com.pojo.Bvo;
import com.pojo.User;
import com.service.serviceImpl.BvoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 18:09
 **/
@PreAuthorize("hasRole('1')")
@RestController
@RequestMapping("api/bvo/bvo")
public class BvoControllerImpl implements BvoController {

    final
    BvoServiceImpl bovService;

    @Autowired
    public BvoControllerImpl(BvoServiceImpl bovService) {
        this.bovService = bovService;
    }

    @RequestMapping("register")
    public Map register(User user, Bvo bvo){
        return  bovService.register(user,bvo);
    }

}
