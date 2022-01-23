package com.ybourne.bookmanagerjk.configuration;

import com.ybourne.bookmanagerjk.interceptor.HostInfoInterceptor;
import com.ybourne.bookmanagerjk.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class BookWebConfiguration implements WebMvcConfigurer {

    @Autowired
    private HostInfoInterceptor hostInfoInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry){
                registry.addInterceptor(hostInfoInterceptor).addPathPatterns("/**");
                registry.addInterceptor(loginInterceptor).addPathPatterns("/books/**");
            }
        };
//        return addInterceptors(InterceptorRegistry registry)->{ }
    }
}
