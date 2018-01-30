package com.shipinfo.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;

/**
 * Created by zhen_Tomcat on 2017/12/22.
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{


    //从Spring Framework 4.2起，开箱即用的支持CORS,无需自己配置CORSFilter，或者使用注解，@CrossOrigin

  /*  @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/")
                .allowedOrigins("http://localhost:8080")
                .allowedHeaders("*")
                .allowedMethods("POST","GET","OPTIONS","DELETE")
                .allowedHeaders("x-requested-with,Authorization")
                .allowCredentials(true).maxAge(3600);

    }*/
}
