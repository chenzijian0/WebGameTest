package com.justicekn.webgame.Controller.Login;

import com.justicekn.webgame.Handler.GameBuff.GetBuffRankList;
import com.justicekn.webgame.Handler.Login.LoginHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Login {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    LoginHandler loginHandler;
    //登录时需要获取一次Buff数值, 可以与进入 gameBuff页面的搜索合并 减少搜索次数(待优化)
    @Autowired
    GetBuffRankList getBuffRankList;

    @RequestMapping("/Login")
    public String loggin(String account, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("获取登录信息(未确认) : 账号-->{} 密码-->{}", account, password);
        String result = loginHandler.checked(account, password);
        if (result.equals("ok")) {
//            将账号信息放入Session域中
            /***
             * 待优化区域 ， 可以把3次查询归为一次 提升性能
             */
            request.getSession().setAttribute("userAccount", account);
            int id = loginHandler.findIdAtLogin(account);
            String name = loginHandler.findNameAtLogin(account);
            int kfb = loginHandler.findKfbAtLogin(id);
            request.getSession().setAttribute("userKfb", kfb);
            request.getSession().setAttribute("userName", name);
            request.getSession().setAttribute("userId", id);
            logger.info("用户ID-->{}", id);
////            获取用户游戏属性信息
//            UserGameAttributes userGameAttributes = loginHandler.GetUserGameAttributes(id);
//            logger.info("获取了用户的游戏属性信息: {}", userGameAttributes);
//            request.getSession().setAttribute("userAttributesFromDataBase", userGameAttributes);
////获取Buff信息
//            double buffValue = getBuffRankList.getMyBuffValue(id);
//            request.getSession().setAttribute("buffValue",buffValue);
//            response.sendRedirect("/GamePage/gameMain.html");
            return "redirect:GamePage/gameMain.html";
        } else {
            request.setAttribute("loginErrorMsg", "账号或密码错误");
//            request.getRequestDispatcher("/index.html").forward(request,response);
            return "index";
        }
    }
}
