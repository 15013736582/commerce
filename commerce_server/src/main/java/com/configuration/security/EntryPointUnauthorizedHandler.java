package com.configuration.security;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-02 20:18
 **/
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    /**
     * 未登录或无权限时触发的操作
     * 返回  {"code":401,"message":"小弟弟，你没有携带 token 或者 token 无效！","data":""}
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException, IOException {
        //返回json形式的错误信息
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        Map<String, Object> result = new HashMap<>();
        result.put("state",401);
        result.put("msg", "token无效");
        httpServletResponse.getWriter().println(JSON.toJSONString(result));
        httpServletResponse.getWriter().flush();
    }

}