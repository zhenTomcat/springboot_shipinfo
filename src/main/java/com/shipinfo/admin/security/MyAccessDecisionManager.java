package com.shipinfo.admin.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by zhen_Tomcat on 2017/12/21.
 */


@Service
public class MyAccessDecisionManager implements AccessDecisionManager{
    private AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        System.err.print(authentication);
        Iterator<ConfigAttribute> ite=configAttributes.iterator();
        while (ite.hasNext()){
            ConfigAttribute ca=ite.next();
            String needRole=((SecurityConfig)ca).getAttribute();

            for (GrantedAuthority ga:authentication.getAuthorities()){
                String role=ga.getAuthority().trim();
                if (needRole.trim().endsWith(role)||role.equals("ROLE_ADMIN")){
                    return;
                }
            }
        }
        throw new AccessDeniedException("该请求，没有授权");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
