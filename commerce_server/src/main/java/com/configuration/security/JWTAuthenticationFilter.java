package com.configuration.security;

import com.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-02 15:36
 **/
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    /**
     * 在此方法中检验客户端请求头中的token,
     * 如果存在并合法,就把token中的信息封装到 Authentication 类型的对象中,
     * 最后使用  SecurityContextHolder.getContext().setAuthentication(authentication); 改变或删除当前已经验证的 pricipal
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException  {

        String token = request.getHeader("token");

        //判断是否有token
        if (token == null || token.equals("")) {
            chain.doFilter(request, response);
            return;
        }
        // 创建一个认证信息实例
        // 1.创建当前用户的角色信息

        Authentication authenticationToken = getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        chain.doFilter(request, response);
    }

    /**
     * 解析token中的信息,并判断是否过期
     */
    private Authentication getAuthentication(String token) throws AuthenticationException {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            try {
            Claims claims = JwtUtil.parseJWT(token);
            String type = "ROLE_"+ String.valueOf(claims.get("type")) ;
            authorities.add(new SimpleGrantedAuthority(type));
            Authentication authentication = new UserAuthentication(authorities);
            authentication.setAuthenticated(true);
            return authentication;
        } catch (Exception e) {
                        return null;
        }
    }


}
