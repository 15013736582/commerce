package com.controller.controllerImpl;

import com.pojo.Pro;
import com.service.serviceImpl.ProServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("api/pro")
public class ProControllerImpl {

    @Autowired
    ProServiceImpl proService;

    @RequestMapping("queryAll")
    public Map<String, Object> queryAll(){
        return proService.queryAll();
    }

    @RequestMapping("queryByState")
    public Map<String, Object> queryByState(int state){
        return proService.queryByState(state);
    }

    @RequestMapping("upload")
    public Map upload(@RequestParam("proImg") MultipartFile file, HttpSession session) {
        return proService.fileUpload(file);
    }

    @RequestMapping("add")
    public Map add(Pro pro){
        return proService.add(pro);
    }

    @RequestMapping("findByPname")
    public  Map findByPname(String title){
        return  proService.findByPname(title);
    }
}
