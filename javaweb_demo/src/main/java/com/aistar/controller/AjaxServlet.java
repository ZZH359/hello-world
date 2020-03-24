package com.aistar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet",urlPatterns = "/ajax_demo")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if (option.equals("ajaxdemo2")){
            demo2(request,response);
        }else if (option.equals("ajaxdemo1")){
            demo1(request,response);
        }else if (option.equals("ajaxdemo3")){
            demo3(request,response);
        }else {

        }

        System.out.println("servlet接收到Ajax请求！");

    }

    private void demo1(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    }
    private void demo2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id= request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println("id= "+id);
        System.out.println("name= "+name);
    }

    private void demo3(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        System.out.println(request.getParameter("proName"));
        System.out.println(request.getParameter("proNum"));
        System.out.println(request.getParameter("proPrice"));
        System.out.println(request.getParameter("proAddress"));
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
