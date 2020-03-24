package com.aistar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AddCookieDemoServlet",urlPatterns = "/addcookie_demo")
public class AddCookieDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "Tom";
        String userpwd = "123456";
        //1.创建Cookie
        Cookie usernameCookie = new Cookie("uesrname",username);
        Cookie userpwdCookie = new Cookie("userpwd",userpwd);
        //2.设置Cookie参数：生命周期、路径
        usernameCookie.setMaxAge(3600);
        userpwdCookie.setMaxAge(3600);
        usernameCookie.setPath(request.getContextPath());
        userpwdCookie.setPath(request.getContextPath());
        //3.将Cookie写入客户端
        response.addCookie(usernameCookie);
        response.addCookie(userpwdCookie);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
