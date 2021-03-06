package com.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dto.ConstantQiniu;
import com.dto.ResultState;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.mapper.ProMapper;
import com.pojo.Pro;
import com.pojo.ProExample;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.service.ProService;
import com.util.MyPage;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProServiceImpl implements ProService {

    @Autowired
    private ProMapper proMapper;

    @Autowired
    ConstantQiniu qiniu;

    /**
     * @return
     */
    public Map<String, Object> queryAll() {
        Map<String, Object> result = new HashMap<>();
        ProExample ex = new ProExample();
        ProExample.Criteria criteria = ex.createCriteria();
        List list = proMapper.selectByExample(ex);
        result.put("state", 0);
        result.put("proList", list);
        return result;
    }

    public Map<String, Object> queryByState(int state) {
        Map<String, Object> result = new HashMap<>();
        ProExample ex = new ProExample();
        ProExample.Criteria criteria = ex.createCriteria();
        criteria.andStatusEqualTo(state);
        List list = proMapper.selectByExample(ex);
        result.put("state", 0);
        result.put("proList", list);
        return result;
    }

    /**
     * @param file
     * @return
     */
    public Map fileUpload(MultipartFile file) {
        String a = qiniu.getAccessKey();
        Map<String, Object> result = new HashMap<>();
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        String fileName = file.getOriginalFilename();
        int dotIndex = fileName.lastIndexOf('.');
        fileName = fileName.substring(0, dotIndex) + "_" + new Date().getTime()
                + fileName.substring(dotIndex, fileName.length());
        Auth auth = Auth.create(qiniu.getAccessKey(), qiniu.getSecretKey());
        String upToken = auth.uploadToken(qiniu.getBucket());
        try {
            Response response = uploadManager.put(file.getInputStream(), fileName, upToken, null, null);
            JSONObject res = JSON.parseObject(response.bodyString());
            result.put("state", "0");
            result.put("imgSrc", res.get("key"));
        } catch (QiniuException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void update(Pro pro){
        proMapper.updateByPrimaryKeySelective(pro);
    }

    public List findByUserId(int userId,MyPage page) {

        ProExample ex = new ProExample();
        ProExample.Criteria cr = ex.createCriteria();
        cr.andMIdEqualTo(userId);
        PageHelper.startPage(page.getCurrPage(), page.getPageSize());
        List list =  proMapper.selectByExample(ex);
        return list;
    }

    public Map add(Pro pro){
        Map result = new HashMap();
        pro.setAddDate(new Date());
        proMapper.insertSelective(pro);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }

    public Map del(int id){
        Map<String, Object> result = new HashMap<>();
        proMapper.deleteByPrimaryKey(id);
        result.put("state", ResultState.SECCESS.getState());
        return result;
    }

    public  Map findByPname(String title){
        Map<String,Object> result=new HashMap<>();
        ProExample ex=new ProExample();
        ProExample.Criteria criteria=ex.createCriteria();
        String t="%"+title+"%";
        criteria.andTitleLike(t);
        List list=proMapper.selectByExample(ex);
        result.put("state", ResultState.SECCESS.getState());
        result.put("proList",list);
        return  result;
    }

    public MyPage getPage(int userId){
        MyPage myPage = new MyPage();
        ProExample ex = new ProExample();
        ProExample.Criteria cr = ex.createCriteria();
        cr.andMIdEqualTo(userId);
        myPage.setTotalCount((int) proMapper.countByExample(ex));
        myPage.setPageSize(6);
        myPage.init();
        return myPage;
    }

    public Pro findById(int id){
        return proMapper.selectByPrimaryKey(id);
    }


    public List findWish(int uid){
        return proMapper.findWish(uid);
    }
}
