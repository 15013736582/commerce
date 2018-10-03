package com.controller.controllerImpl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-01 21:08
 **/
@RestController
@PreAuthorize("hasRole('1')")
public class SecurityCtrl {
    @GetMapping("/security/s1")
    public String s1() {
        return "s1";
    }

    @GetMapping("/security/s2")
    public String s2() {
        return "s2";
    }

}