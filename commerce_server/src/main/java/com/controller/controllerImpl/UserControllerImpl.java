package com.controller.controllerImpl;

import com.controller.UserController;
import com.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-27 13:00
 **/
@RestController
@RequestMapping("/")
public class UserControllerImpl implements UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("test")
    public String add(){
        System.out.println( "!!!!!!!!!");
        return "OK";
    }


}
