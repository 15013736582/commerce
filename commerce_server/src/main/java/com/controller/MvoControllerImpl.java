package com.controller;

import com.pojo.Mvo;
import com.pojo.User;
import com.service.serviceImpl.MvoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 21:43
 **/
@RestController
@RequestMapping("api/mvo/mvo")
public class MvoControllerImpl {

    @Autowired
    MvoServiceImpl mvoService;

    @RequestMapping("register")
    public Map register(User user, Mvo mvo) {
        return mvoService.register(user, mvo);
    }
}
