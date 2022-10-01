package com.woomq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author woo-mq
 * 设置拦截器
 */
@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后应该用对应用户的session
        Object loginUser = request.getSession().getAttribute("user");
        System.out.println("拦截器");
        if(loginUser==null){
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;

        }
        return true;
    }
}
