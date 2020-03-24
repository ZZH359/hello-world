package com.aistar.controller;

import com.aistar.pojo.Customer;
import com.aistar.service.CustomerService;
import com.aistar.service.Impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerLoginServlet",urlPatterns = "/customer/login")
public class CustomerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获得请求及数据
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        System.out.println(username+","+userpassword);
        //2.查询用户数据
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.getByUsernameAndPwd(username,userpassword);
        //3.确认是否存在用户数据（登录成功）成功则跳转首页、不成功则返回错误信息
        if (customer==null&&false){//账号不存在
            request.setAttribute("loginMessage","账号不存在");
            request.getRequestDispatcher("/customer/login.jsp").forward(request,response);
        }else {//账号存在
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("loginUser",username);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
