package com.controller.controllerImpl;

import com.dto.ResultState;
import com.pojo.WalletOrder;
import com.service.WalletOrderService;
import com.service.serviceImpl.WalletOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-10 00:25
 **/
@RestController
@RequestMapping("/api/walletOrder")
public class WalletOrderControllerImpl {
    @Autowired
    WalletOrderServiceImpl walletOrderService;

    @RequestMapping("add")
    public Map add(WalletOrder walletOrder){
        return walletOrderService.add(walletOrder);
    }

    @RequestMapping("findAll")
    public Map findAll(){
        return walletOrderService.findAll();
    }

    @RequestMapping("update")
    public Map update(WalletOrder walletOrder){
        return walletOrderService.update(walletOrder);
    }

}
