package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.BvoOrderMapper;
import com.pojo.*;
import com.service.BvoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    public BvoOrderServiceImpl(BvoOrderMapper bvoOrderMapper, BORderItemServiceImpl boRderItemService) {
        this.bvoOrderMapper = bvoOrderMapper;
        this.boRderItemService = boRderItemService;
    }

    public Map add(Pro pro, int userId){
        Map<String, Object> result = new HashMap<>();
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


    public Map findByUserIdAndIsPay(int userId,int isPay){
        Map<String, Object> result = new HashMap<>();
        BvoOrderExample ex = new BvoOrderExample();
        BvoOrderExample.Criteria cr = ex.createCriteria();
        cr.andUIdEqualTo(userId);
        cr.andIsPayEqualTo(isPay);
        result.put("state", ResultState.SECCESS.getState());
        result.put("waitOrders",bvoOrderMapper.selectByExample(ex) );
        return result;
    }
}
