package com.configuration.security;

import com.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-01 17:42
 **/
public class    JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    private AuthenticationSuccessHandler successHandler;

    public JWTLoginFilter() {
    }

    public JWTLoginFilter(AuthenticationManager authManager) {
        setAuthenticationManager(authManager);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication auth) throws IOException, ServletException {

        Map<String, Object> map = new HashMap<>();
        map.put("user","userInfo");
        String token = "";
        try {
           token =  JwtUtil.createJWT("0",map,1000*60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.addHeader("Authorization",token);
    }

    public void setSuccessHandler(AuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

}