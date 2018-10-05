package com.controller.controllerImpl;

import com.service.serviceImpl.ProServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}