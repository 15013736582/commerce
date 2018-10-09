package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.BvoOrderMapper;
import com.pojo.*;
import com.service.BvoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-08 12:55
 **/
@Service
public class BvoOrderServiceImpl implements BvoOrderService {

    final BvoOrderMapper bvoOrderMapper;

    final BORderItemServiceImpl boRderItemService;

    final ProServiceImpl proService;

    final WalletServiceImpl walletService;

    final UserServiceImpl userService;

    @Autowired
    public BvoOrderServiceImpl(BvoOrderMapper bvoOrderMapper, BORderItemServiceImpl boRderItemService, ProServiceImpl proService, WalletServiceImpl walletService, UserServiceImpl userService) {
        this.bvoOrderMapper = bvoOrderMapper;
        this.boRderItemService = boRderItemService;
        this.proService = proService;
        this.walletService = walletService;
        this.userService = userService;
    }

    public Map add(Pro pro, int userId) {
        Map<String, Object> result = new HashMap<>();
        BvoOrderDetail bvoOrderDetail = exist(userId, pro.getId());
        if (bvoOrderDetail != null) {
            BvoOrder bvoOrder = new BvoOrder();
            bvoOrder.setId(bvoOrderDetail.getId());
            bvoOrder.setQty(bvoOrderDetail.getQty() + 1);
            double proPrice = proService.findById(bvoOrderDetail.getOrderItem().getpId()).getPrice();
            bvoOrder.setPrice(bvoOrderDetail.getPrice() + proPrice);
            update(bvoOrder);
            result.put("state", ResultState.SECCESS.getState());
            return result;
        }

        BvoOrder bvoOrder = new BvoOrder();
        bvoOrder.setCreateDate(new Date());
        bvoOrder.setIsPay(0);
        bvoOrder.setPrice(pro.getPrice());
        bvoOrder.setuId(userId);
        bvoOrder.setTitle(pro.getTitle());
        bvoOrder.setQty(1);
        bvoOrderMapper.insertSelective(bvoOrder);

        BOrderItem bOrderItem = new BOrderItem();
        bOrderItem.setCount(1);
        bOrderItem.setoId(bvoOrder.getId());
        bOrderItem.setpId(pro.getId());
        boRderItemService.add(bOrderItem);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }


    public Map findByUserIdAndIsPay(int userId, int isPay) {
        Map<String, Object> result = new HashMap<>();
        BvoOrderExample ex = new BvoOrderExample();
        BvoOrderExample.Criteria cr = ex.createCriteria();
        cr.andUIdEqualTo(userId);
        cr.andIsPayEqualTo(isPay);
        result.put("state", ResultState.SECCESS.getState());
        result.put("orders", bvoOrderMapper.selectByExample(ex));
        return result;
    }

    public BvoOrderDetail exist(int userId, int proId) {
        List<BvoOrderDetail> orders = bvoOrderMapper.findOrderDetail(userId);
        for (BvoOrderDetail item : orders) {
            if (item.getuId() == userId && item.getOrderItem().getpId() == proId) {
                return item;
            }
        }
        return null;
    }

    public void update(BvoOrder bvoOrder) {
        bvoOrderMapper.updateByPrimaryKeySelective(bvoOrder);
    }

    public Map pay(BvoOrder bvoOrder){
        Map<String, Object> result = new HashMap<>();
        User user = userService.findById(bvoOrder.getuId());
        Wallet wallet = walletService.findById(user.getWalletId());
        if (wallet.getMoney() < bvoOrder.getPrice()) {
            result.put("state", ResultState.Fail.getState());
            result.put("msg", "余额不足");
        }
        bvoOrder.setId(bvoOrder.getId());
        bvoOrder.setIsPay(1);
        bvoOrderMapper.updateByPrimaryKeySelective(bvoOrder);
        wallet.setMoney(wallet.getMoney()-bvoOrder.getPrice());
        walletService.update(wallet);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }


}
