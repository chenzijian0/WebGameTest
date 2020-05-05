package com.justicekn.webgame.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userAccount = request.getSession().getAttribute("userAccount");
        if(userAccount==null) {
            request.setAttribute("Permission_denied","没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
//            System.out.println("拦截目标： " + request.getRequestURI());
//            System.out.println("已经拦截目标");
            return false;
        }
        else return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
