package com.justicekn.webgame.Configuration;

import com.justicekn.webgame.Component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**").excludePathPatterns(
                "/favicon.ico"
                ,"/error"
                ,"/index.html","/","/Login","/index"
                ,"/webjars/**","/css/**","/js/**","/img/**"
                ,"/Test"
                ,"/register.html" ,"/register"
                ,"/druid/**"
                ,"/GamePage/FightInf/FightInf.html"
//                ,"/forgot.html","forgot"
//                ,"/GamePage/gameMain.html"
        );
    }
}
