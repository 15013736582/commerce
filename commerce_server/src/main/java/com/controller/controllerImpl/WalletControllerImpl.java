package com.controller.controllerImpl;

import com.pojo.Wallet;
import com.service.serviceImpl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/wallet")
public class WalletControllerImpl {
    @Autowired
    WalletServiceImpl walletService;
    @RequestMapping("register")
    public Map walletRegister(Wallet wallet, int userId) {
        return walletService.register(wallet,userId);
    }
    @RequestMapping("find")
    public  Map find(int userId){
        return walletService.find(userId);
    }
}
