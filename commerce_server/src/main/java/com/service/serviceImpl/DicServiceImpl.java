package com.service.serviceImpl;

import com.mapper.DicMapper;
import com.pojo.Dic;
import com.pojo.DicExample;
import com.service.DicService;
import com.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.ExtendedResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-04 00:33
 **/
@Service
public class DicServiceImpl implements DicService {

    private final DicMapper dicMapper;

    @Autowired
    public DicServiceImpl(DicMapper dicMapper) {
        this.dicMapper = dicMapper;
    }

    /**
     *
     * @param type
     * @return  Map dicList 返回dic列表
     */
    public Map findBytype(String type){
        Map<String, Object> result = new HashMap<>();
        DicExample ex = new DicExample();
        DicExample.Criteria cr = ex.createCriteria();
        cr.andTypeEqualTo(type);
        result.put("state",0);
        result.put("dicList",dicMapper.selectByExample(ex));
        return result;
    }

    public Map findAll(){
        Map<String, Object> result = new HashMap<>();
        result.put("dicList",dicMapper.selectByExample(null));
        return result;
    }
}
