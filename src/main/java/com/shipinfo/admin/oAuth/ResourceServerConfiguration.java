package com.shipinfo.admin.oAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
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
        /*http.authorizeRequests()
                .antMatchers("/sys/registry","/me","/mm").permitAll()
                ;*/
        http.requestMatchers().antMatchers("/ship/**","/role/**",
                "/right/**","/user/**","/file/**","/port/**")
                .and()
                .authorizeRequests()
                .antMatchers("/ship").permitAll().anyRequest().authenticated()//只有上面的请求，才能被认证，
                                                                            // 只有/ship 不需要被认证，可以直接访问
                                                                            //其他请求，都要被认证，数据库中也不能有该资源信息，
                                                                            // 因为我自定义的拦截器会将其拦截
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        http.addFilterBefore(filterSecurityInterceptor,FilterSecurityInterceptor.class);

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(false);
    }
}
