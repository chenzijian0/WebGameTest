package com.justicekn.webgame.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSiteMapping implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/forgot.html").setViewName("forgot");
        registry.addViewController("/GamePage/gameMain.html").setViewName("/GamePage/gameMain");
        registry.addViewController("/GamePage/gameHelp.html").setViewName("/GamePage/gameHelp");
        registry.addViewController("/GamePage/gameItem.html").setViewName("/GamePage/gameItem");
        registry.addViewController("/GamePage/gameShop.html").setViewName("/GamePage/gameShop");
        registry.addViewController("/GamePage/gameBuff.html").setViewName("/GamePage/gameBuff");
//        registry.addViewController("/GamePage/gameRanking.html").setViewName("/GamePage/gameRanking");
    }
}
