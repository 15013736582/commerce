package com.controller.controllerImpl;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptorAdapter implements HandlerInterceptor {
    /*false 请求结束*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
//        String token = httpServletRequest.getHeader("token");
//        try {
//            JwtUtil.parseJWT(token);
//        }catch (Exception e){
//            httpServletResponse.sendRedirect("/api/error/signError");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
