package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.WalletOrderMapper;
import com.pojo.Wallet;
import com.pojo.WalletOrder;
import com.service.WalletOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-10 00:18
 **/
@Service
public class WalletOrderServiceImpl implements WalletOrderService {

    final WalletOrderMapper walletOrderMapper;

    final WalletServiceImpl walletService;

    @Autowired
    public WalletOrderServiceImpl(WalletOrderMapper walletOrderMapper, WalletServiceImpl walletService) {
        this.walletOrderMapper = walletOrderMapper;
        this.walletService = walletService;
    }

    public Map add(WalletOrder walletOrder){
        Map<String, Object> result = new HashMap<>();
        Wallet wallet  = walletService.findById(walletOrder.getwId());
        if(walletOrder.getType() == 1){
            wallet.setMoney(wallet.getMoney()-walletOrder.getMoney());
            walletService.update(wallet);
        }
        walletOrder.setCreateDate(new Date());
        walletOrderMapper.insertSelective(walletOrder);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }

    public Map findAll(){
        Map<String, Object> result = new HashMap<>();
        result.put("state", ResultState.SECCESS.getState());
        result.put("orders", walletOrderMapper.findWalletOrderDetaail());
        return result;
    }

    public Map update(WalletOrder walletOrder){
        Map<String, Object> result = new HashMap<>();
        Wallet wallet = walletService.findById(walletOrder.getwId());
        switch (walletOrder.getType()){
            case 0:{
                wallet.setMoney(wallet.getMoney()+walletOrder.getMoney());
                break;
            }
            case 1:{
                wallet.setMoney(wallet.getMoney()+walletOrder.getMoney());
                break;
            }
        }
        walletService.update(wallet);
        walletOrderMapper.updateByPrimaryKeySelective(walletOrder);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }
}
