//package com.goku.wiki.config;
//
////import com.goku.wiki.interceptor.ActionInterceptor;
//import com.goku.wiki.interceptor.LogInterceptor;
////import com.goku.wiki.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.annotation.Resource;
//
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//    @Resource
//    LogInterceptor logInterceptor;
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login");
//
//    }
//}
