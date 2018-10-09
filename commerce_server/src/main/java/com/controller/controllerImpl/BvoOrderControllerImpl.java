package com.controller.controllerImpl;

import com.mapper.BvoOrderMapper;
import com.pojo.BvoOrder;
import com.pojo.BvoOrderDetail;
import com.pojo.Pro;
import com.service.serviceImpl.BvoOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-08 18:58
 **/

@RestController
@RequestMapping("api/bvoOrder")
public class BvoOrderControllerImpl {

    @Autowired
    BvoOrderServiceImpl bvoOrderService;

    @RequestMapping("buyOne")
    public Map buyOne(int userId, Pro pro){
        return bvoOrderService.add(pro,userId);
    }

    @RequestMapping("findByUserIdAndIsPay")
    public Map findByUserIdAndIsPay(int userId,int isPay){
        return bvoOrderService.findByUserIdAndIsPay(userId,isPay);
    }

    @RequestMapping("pay")
    public Map pay(BvoOrder bvoOrder){
        return bvoOrderService.pay(bvoOrder);
    }
}
