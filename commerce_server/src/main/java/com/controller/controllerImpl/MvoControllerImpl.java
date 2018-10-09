package com.controller.controllerImpl;

import com.pojo.Mvo;
import com.pojo.Pro;
import com.pojo.User;
import com.service.serviceImpl.MvoOrderServiceImpl;
import com.service.serviceImpl.MvoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-28 21:43
 **/

@PreAuthorize("hasRole('1')")
@RestController
@RequestMapping("api/mvo")
public class MvoControllerImpl {

    final MvoOrderServiceImpl mvoOrderService;

    final MvoServiceImpl mvoService;

    @Autowired
    public MvoControllerImpl(MvoOrderServiceImpl mvoOrderService, MvoServiceImpl mvoService) {
        this.mvoOrderService = mvoOrderService;
        this.mvoService = mvoService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping("register")
    public Map register(User user, Mvo mvo) {
        return mvoService.register(user, mvo);
    }

    @RequestMapping("selfInfo")
    public Map selfInfo(int userId) {
        return mvoService.findByUserId(userId);
    }

    @RequestMapping("update")
    public Map updata(Mvo mvo) {
        return mvoService.updata(mvo);
    }

    @RequestMapping("findProByUserId")
    public Map findProByUserId(int userId) {
        return mvoService.findProAll(userId);
    }

    @RequestMapping("updatePro")
    public Map updatePro(Pro pro) {
        return mvoService.updatePro(pro);
    }

    @RequestMapping("delPro")
    public Map delPro(int proId) {
        return mvoService.delPro(proId);
    }


}
