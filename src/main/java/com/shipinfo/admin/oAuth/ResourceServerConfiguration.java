package com.shipinfo.admin.oAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by zhen_Tomcat on 2017/12/26.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";

    @Autowired
    private FilterSecurityInterceptor filterSecurityInterceptor;
    @Override
    public void configure(HttpSecurity http) throws Exception {

        // .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//设置跨域访问
        http.antMatcher("/oauth2/api/**").authorizeRequests()
                .antMatchers("/sys/registry","/me").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        http.addFilterBefore(filterSecurityInterceptor,FilterSecurityInterceptor.class);

    }
}
