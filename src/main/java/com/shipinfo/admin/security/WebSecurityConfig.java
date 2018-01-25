//package com.shipinfo.admin.security;
//
//import com.shipinfo.admin.security.LoginSuccessHandler;
//import com.shipinfo.admin.security.MyFilterSecurityInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.web.access.DefaultWebInvocationPrivilegeEvaluator;
//import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Created by zhen_Tomcat on 2017/12/21.*/
//
//
//
//
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private MyFilterSecurityInterceptor  filterSecurityInterceptor;
//
//
///*
//<sec:authorize之类的已经不能起效了
//    * 需要一个DefaultWebInvocationPrivilegeEvaluator决策器实例,\
//    * 直接配置一个实例然后注入FilterSecurityInterceptor的实例即可
//    *
//*/
//
//
//    @Bean
//    public ClientDetailsService clientDetailsService(){
//        return new InMemoryClientDetailsService();
//    }
//
//    @Bean
//    public AuthorizationServerTokenServices authorizationServerTokenServices(){
//        return new DefaultTokenServices();
//    }
//
//
//
//@Bean
//    @Primary
//    public DefaultWebInvocationPrivilegeEvaluator customWebInvocationPrivilegeEvaluator() {
//        return new DefaultWebInvocationPrivilegeEvaluator(filterSecurityInterceptor);
//     }
//
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//
//        return super.authenticationManagerBean();
//
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.//在正确位置添加我们自定义的过滤器
//                authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .anyRequest().authenticated()
//                //.antMatchers("/hello").hasAnyAuthority("ROLE_ADMIN")
//                .and()
//                .formLogin().loginPage("/login")
//                .permitAll()
//                .successHandler(loginSuccessHandler())
//                .and()
//                .logout().permitAll();
//        http.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class);
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(4);
//    }
//
//    @Bean
//    public LoginSuccessHandler loginSuccessHandler(){
//        return new LoginSuccessHandler();
//    }
//
//
//}
