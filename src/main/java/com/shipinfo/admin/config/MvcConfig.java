package com.shipinfo.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;
import java.util.Arrays;

/**
 * Created by zhen_Tomcat on 2017/12/22.
 */

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {


    //从Spring Framework 4.2起，开箱即用的支持CORS,无需自己配置CORSFilter，或者使用注解，@CrossOrigin
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/oauth/token")
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("POST", "GET", "OPTIONS", "DELETE")
//                .allowedHeaders("x-requested-with,Authorization")
//                .allowCredentials(true).maxAge(3600);
//
//    }


//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*").
//                allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE").
//                allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization").
//                allowCredentials(true);
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
