package com.amirul.spring.springbootmysql.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amirul.spring.springbootmysql.interceptor.MyInterceptor;
import com.amirul.spring.springbootmysql.interceptor.MyPermissionsInterceptor;
import com.amirul.spring.springbootmysql.interceptor.MyUserInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyUserInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(new MyPermissionsInterceptor()).addPathPatterns("/permissions/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
