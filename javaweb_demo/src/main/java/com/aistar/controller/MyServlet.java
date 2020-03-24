package com.aistar.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    //无参构造函数
    public MyServlet(){
        System.out.println("MyServlet构造函数");
    }

    //初始化
    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet初始化。。。init");
    }
    //业务函数
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet业务。。。");
    }
    //消亡
    @Override
    public void destroy() {
        System.out.println("MyServlet消亡。。。destroy");
    }


}
