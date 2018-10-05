package com.util;

import com.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-18 15:00
 **/
public class CookieUtile {
    public static void setCookie (String token, User user,String type){
        int time = 60*60*24*10000;
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        Cookie cookie = new javax.servlet.http.Cookie("token",token);
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new javax.servlet.http.Cookie("userType",type);
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new javax.servlet.http.Cookie("userId",String.valueOf(user.getId()));
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
        cookie = new javax.servlet.http.Cookie("userName",user.getNickname());
        cookie.setMaxAge(time);
        cookie.setPath("/");
        response.addCookie(cookie);
        return;
    }
}
