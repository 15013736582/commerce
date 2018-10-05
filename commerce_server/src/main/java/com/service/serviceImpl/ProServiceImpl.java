package com.service.serviceImpl;

import com.mapper.ProMapper;
import com.pojo.Pro;
import com.pojo.ProExample;
import com.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    private ProMapper proMapper;

    public Map<String,Object> queryAll() {
        Map<String,Object> result=new HashMap<>();
        ProExample ex = new ProExample();
        ProExample.Criteria criteria = ex.createCriteria();
        List list = proMapper.selectByExample(ex);
        result.put("state",0);
        result.put("proList",list);
        return result;
    }

}
