package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.WalletMapper;
import com.pojo.User;
import com.pojo.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceImpl {
    final
    WalletMapper walletMapper;
    final UserServiceImpl userService;
    @Autowired
    public WalletServiceImpl(WalletMapper walletMapper, UserServiceImpl userService) {
        this.walletMapper = walletMapper;
        this.userService = userService;
    }

    public Map register(Wallet wallet,int userId){
        Map<String,Object> result=new HashMap<>();
        wallet.setCreateDate(new Date());
        walletMapper.insertSelective(wallet);
        User user=new User();
        user.setId(userId);
        user.setWalletId(wallet.getId());
        userService.addWallet(user);
        result.put("state", ResultState.SECCESS.getState());
        return  result;
    }

    public Map find(int userId){
        Map<String,Object> result=new HashMap<>();
       User user= userService.findById(userId);
       if(user.getWalletId()!=null){
           result.put("wallet",walletMapper.selectByPrimaryKey(user.getWalletId()));
       }
       return  result;
    }
}
