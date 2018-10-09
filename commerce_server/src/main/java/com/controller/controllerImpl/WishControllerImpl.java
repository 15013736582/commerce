package com.controller.controllerImpl;

import com.service.serviceImpl.WishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/wish")
public class WishControllerImpl {
    @Autowired
    WishServiceImpl wishService;
    @RequestMapping("add")
    public Map addWish(int uid,int pid){
      return   wishService.addWish(uid,pid);
    }
    @RequestMapping("find")
    public Map findWish(int uid){
        return  wishService.findWish(uid);
    }
    @RequestMapping("del")
    public  Map delWish(int uid,int pid){
        return wishService.delWish(uid,pid);
    }
}
