package com.configuration.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-02 15:38
 **/
public class UserAuthentication extends AbstractAuthenticationToken {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;

    public UserAuthentication(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public UserAuthentication(Collection<? extends GrantedAuthority> authorities, String name) {
        super(authorities);
        this.name = name;
    }

    @Override
    public Object getCredentials() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

}
