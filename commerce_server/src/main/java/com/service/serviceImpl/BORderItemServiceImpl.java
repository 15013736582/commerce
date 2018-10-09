package com.service.serviceImpl;

import com.mapper.BOrderItemMapper;
import com.pojo.BOrderItem;
import com.pojo.BvoOrderExample;
import com.service.BORderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-08 12:56
 **/
@Service
public class BORderItemServiceImpl implements BORderItemService {

    @Autowired
    BOrderItemMapper bOrderItemMapper;
    public void add(BOrderItem bOrderItem){
        bOrderItemMapper.insertSelective(bOrderItem);
    }


    public List findMvoOrderDetailById(Map map){
        return bOrderItemMapper.findMvoOrderDetail(map);
    }
}
