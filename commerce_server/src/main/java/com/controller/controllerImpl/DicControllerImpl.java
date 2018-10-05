package com.controller.controllerImpl;

import com.controller.DicController;
import com.pojo.Dic;
import com.service.serviceImpl.DicServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Div;
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

    @RequestMapping("update")
    public Map update(Dic dic){
        return  dicService.update(dic);
    }

    @RequestMapping("del")
    public Map del(Dic dic){
        return dicService.del(dic.getId());
    }

    @RequestMapping("add")
    public Map add(Dic dic){
        return dicService.add(dic);
    }
}
