package com.controller.controllerImpl;

import com.controller.DicController;
import com.service.serviceImpl.DicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-04 00:32
 **/
@RestController
@RequestMapping("/api/dic")
public class DicControllerImpl implements DicController {

    @Autowired
    DicServiceImpl dicService;

    @RequestMapping("type")
    public Map type(String type){
        return dicService.findBytype(type);
    }

    @RequestMapping("all")
    public Map all(){
        return dicService.findAll();
    }
}
