package com.aistar.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(filterName = "MyFilter",urlPatterns = "/index.jsp")
public class MyFilter implements Filter {
    public MyFilter(){
        System.out.println("MyFilter构造函数。。。。");
    }
    public void destroy() {
        System.out.println("MyFilter销毁。。。。");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyFilter正在过滤。。。。");
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("MyFilter初始化。。。。");
    }

}
