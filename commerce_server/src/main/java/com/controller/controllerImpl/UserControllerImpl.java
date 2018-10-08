package com.controller.controllerImpl;

import com.controller.UserController;
import com.pojo.User;
import com.pojo.Wallet;
import com.service.serviceImpl.UserServiceImpl;
import com.service.serviceImpl.WalletServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-30 17:01
 **/
@RestController
@RequestMapping("api/user")

public class UserControllerImpl implements UserController {
    final private UserServiceImpl userService;
    final  private WalletServiceImpl walletService;

    public UserControllerImpl(UserServiceImpl userService, WalletServiceImpl walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @RequestMapping("login")
    public Map login(User user) {
        return userService.login(user);
    }



}
