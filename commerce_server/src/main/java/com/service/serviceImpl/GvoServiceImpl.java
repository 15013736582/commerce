package com.service.serviceImpl;

import com.mapper.GvoMapper;
import com.pojo.Gvo;
import com.service.GvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-30 16:42
 **/
@Service
public class GvoServiceImpl implements GvoService {
    @Autowired
    GvoMapper gvoMapper;

    public Gvo findById(int id){
       return gvoMapper.selectByPrimaryKey(id);
    }
}
