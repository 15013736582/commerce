package com.controller.controllerImpl;

import com.controller.MvoOrderController;
import com.service.serviceImpl.MvoOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-09 06:41
 **/
@RestController
@RequestMapping("api/mvoOrder")
public class MvoOrderControllerImpl implements MvoOrderController {

    final
    MvoOrderServiceImpl mvoOrderService;

    @Autowired
    public MvoOrderControllerImpl(MvoOrderServiceImpl mvoOrderService) {
        this.mvoOrderService = mvoOrderService;
    }

    @RequestMapping("mvoOrderDetail")
    public Map mvoOrderDetail(int userId,int isPay) {
        return mvoOrderService.findMvoOrderDetail(userId,isPay);
    }
}
