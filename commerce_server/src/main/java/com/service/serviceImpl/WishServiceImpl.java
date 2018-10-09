package com.service.serviceImpl;

import com.dto.ResultState;
import com.mapper.WishMapper;
import com.pojo.Wish;
import com.pojo.WishExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WishServiceImpl {
    @Autowired
    WishMapper wishMapper;
    @Autowired
    ProServiceImpl proService;

    public Map addWish(int uid, int pid) {
        Map<String, Object> result = new HashMap<>();
        WishExample ex = new WishExample();
        WishExample.Criteria criteria = ex.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andProIdEqualTo(pid);
        Wish wish = new Wish();
        wish.setProId(pid);
        wish.setUserId(uid);
        wish.setCreateDate(new Date());
        wishMapper.insertSelective(wish);
        result.put("state", ResultState.SECCESS.getState());
        result.put("wish", wishMapper.selectByPrimaryKey(wish.getId()));
        return result;
    }

    public Map queryWish(int uid) {
        Map<String, Object> result = new HashMap<>();
        WishExample ex = new WishExample();
        WishExample.Criteria criteria = ex.createCriteria();
        criteria.andUserIdEqualTo(uid);
        List wish = wishMapper.selectByExample(ex);

        return result;
    }

    public  Map findWish(int uid){
        Map<String,Object> result=new HashMap<>();
        result.put("wishs",proService.findWish(uid));
        return  result;
    }

    public  Map delWish(int uid,int pid){
        Map<String,Object> result=new HashMap<>();
        WishExample ex=new WishExample();
        WishExample.Criteria criteria= ex.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andProIdEqualTo(pid);
        wishMapper.deleteByExample(ex);
        result.put("state",ResultState.SECCESS.getState());
        return  result;
    }
}
