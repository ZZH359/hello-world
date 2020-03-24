package com.aistar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestDemoServlet",urlPatterns = "/request_demo")
public class RequestDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String contextPath = request.getContextPath();
//        System.out.println("contextPath:"+contextPath);
//        System.out.println("serverName:"+request.getServerName());
//        System.out.println("ServletPath:"+request.getServletPath());
//        System.out.println("RequestURI:"+request.getRequestURI());
//        System.out.println("RequestURL:"+request.getRequestURL());
//        System.out.println("ServerPort:"+request.getServerPort());
//        System.out.println("Method:"+request.getMethod());
//        System.out.println("getLocalAddr:"+request.getLocalAddr());
//        String name = request.getParameter("name");
//        String year = request.getParameter("year");
//        String age = request.getParameter("age");
//        String gender = request.getParameter("gender");
//        System.out.println("name:" + name);
//        System.out.println("year:" + year);
//        System.out.println("age:" + age);
//        System.out.println("gender:" + gender);

        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String review = request.getParameter("review");


        //获得性别 radio
        String gender = request.getParameter("gender");
        //获得标签 checkbox
        String[] addTagArr = request.getParameterValues("like");


        System.out.println("username:" + username);
        System.out.println("userpassword:" + userpassword);
        System.out.println("review:" + review);
        System.out.println("gender:" + gender);
        for(String tag:addTagArr){
            System.out.println("addTagArr:" + tag);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
