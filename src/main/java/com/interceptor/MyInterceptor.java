package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    //在控制器执行之前的处
    // 理，返回false,不往下执行，下一个拦截器也不执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor...控制器执行之前的处理");
        String uri = request.getRequestURI();
        if (uri.contains("/n ") || uri.contains("/register")) {
            return true;
        }
        //其他请求
        //以登录，其他请求
        if (request.getSession().getAttribute("user") != null || request.getSession().getAttribute("admin") != null) {
            return true;
        }
        //未登录，访问其他请求
        request.setAttribute("msg", "未登录，请先登录。。。");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    //控制器执行之后，但是没有返回视图，
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor...控制器执行之后，但未返回视图");
    }

    //控制执行之后，并返回了视图，之后的处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor...视图返回之后的处理");
    }
}
