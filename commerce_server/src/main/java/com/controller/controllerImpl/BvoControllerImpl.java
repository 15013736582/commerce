package com.controller.controllerImpl;

import com.controller.BvoController;
import com.pojo.Bvo;
import com.pojo.Store;
import com.pojo.User;
import com.service.serviceImpl.BvoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 18:09
 **/
@PreAuthorize("hasRole('2')")
@RestController
@RequestMapping("api/bvo")
public class BvoControllerImpl implements BvoController {

    final
    BvoServiceImpl bvoService;

    @Autowired
    public BvoControllerImpl(BvoServiceImpl bvoService) {
        this.bvoService = bvoService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping("register")
    public Map register(User user, Bvo bvo){
        return  bvoService.register(user,bvo);
    }

    @RequestMapping("selfInfo")
    public Map selfInfo(int userId){
        return  bvoService.findByUserId(userId);
    }

    @RequestMapping("update")
    public  Map update(Bvo bvo){
        return  bvoService.update(bvo);
    }

    @RequestMapping("findStore")
    public Map findStore(int userId){
        return  bvoService.findStore(userId);
    }

    @RequestMapping("addStore")
    public Map addStore(Store store){
        return  bvoService.addStore(store);
    }

}
