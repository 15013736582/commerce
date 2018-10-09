package com.service.serviceImpl;

import com.dto.ResultState;
import com.service.BORderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-09 03:34
 **/
@Service
public class MvoOrderServiceImpl {

    final
    BORderItemServiceImpl boRderItemService;

    @Autowired
    public MvoOrderServiceImpl(BORderItemServiceImpl boRderItemService1) {
        this.boRderItemService = boRderItemService1;
    }

    public Map findMvoOrderDetail(int userId,int isPay){
        Map<String, Object> result = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("mId", userId);
        map.put("isPay",isPay);
        result.put("state", ResultState.SECCESS.getState());
        result.put("orderList",boRderItemService.findMvoOrderDetailById(map));
        return result;
    }
}
