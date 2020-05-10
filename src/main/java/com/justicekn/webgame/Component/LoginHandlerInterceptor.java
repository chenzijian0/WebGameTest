package com.justicekn.webgame.Component;

import com.justicekn.webgame.DAO.Interface.GameItem.GetUserKfb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
public class LoginHandlerInterceptor implements HandlerInterceptor
{
    @Autowired
    JWTConfiguration jwtConfiguration;
    @Autowired
    GetUserKfb getUserKfb;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String token = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies)
        {
            if (cookie.getName().equals("token"))
            {
                token = cookie.getValue();
            }
        }

        Object userAccount = request.getSession().getAttribute("userAccount");
        if (userAccount != null) return true;
        if (token == null)
        {
            request.setAttribute("Permission_denied", "没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request, response);
//            System.out.println("拦截目标： " + request.getRequestURI());
//            System.out.println("已经拦截目标");
            return false;
        }
        else
        {
//            jwtConfiguration = new JWTConfiguration("098f6bcd4621d373cade4e832627b4f6","MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=","restapiuser",172800000);
            int id = 0;
            String account = JwtTokenUtil.getUserAccount(token, jwtConfiguration.getBase64Secret());
            id = JwtTokenUtil.getUserId(token, jwtConfiguration.getBase64Secret());
            String name = JwtTokenUtil.getUsername(token, jwtConfiguration.getBase64Secret());
            if (id == 0 || name == null || account == null) return false;
            log.info("Token Inf: id --> {}  name --> {}  account --> {}  ", id, name, account);
            request.getSession().setAttribute("userId", id);
            request.getSession().setAttribute("userAccount", account);
            request.getSession().setAttribute("userName", name);
            int kfb = getUserKfb.getKfb(id);
            request.getSession().setAttribute("userKfb", kfb);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {

    }
}
