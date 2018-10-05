package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.DicMapper;
import com.pojo.Dic;
import com.pojo.DicExample;
import com.service.DicService;
import com.util.MyPage;
import org.apache.ibatis.annotations.Results;
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
        result.put("state", ResultState.SECCESS.getState());
        result.put("dicList",dicMapper.selectByExample(ex));
        return result;
    }

    /**
     * @return Map.dicList 返回dic列表
     */
    public Map findAll(){
        Map<String, Object> result = new HashMap<>();
        result.put("dicList",dicMapper.selectByExample(null));
        result.put("state",ResultState.SECCESS.getState());
        return result;
    }

    /**
     * @param dic
     * @return
     */
    public Map update(Dic dic){
        Map<String, Object> result = new HashMap<>();
        dic.setType(null);
        dicMapper.updateByPrimaryKeySelective(dic);
        result.put("state",ResultState.SECCESS.getState());
        return result;
    }

    /**
     * @param dicId
     * @return
     */
    public Map del(int dicId){
        Map<String, Object> result = new HashMap<>();
        dicMapper.deleteByPrimaryKey(dicId);
        result.put("state", ResultState.Fail.getState());
        return result;
    }

    public Map add(Dic dic){
        Map<String, Object> result = new HashMap<>();
        dicMapper.insertSelective(dic);
        result.put("state", ResultState.SECCESS);
        return result;
    }
}
