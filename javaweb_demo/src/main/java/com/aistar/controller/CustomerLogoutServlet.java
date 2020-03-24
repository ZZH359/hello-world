package com.aistar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CustomerLogoutServlet",urlPatterns = "/customer/logout")
public class CustomerLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //登出需要移除session中的登录用户信息，还要删除cookie中的自动登录
       //移除session中的数据
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("logincustomer");
        httpSession.removeAttribute("logincustomername");
        //如果cookie中有自动登录，则删除该数据
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length>0){
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("autologincustomer")){
                    cookie.setMaxAge(0);//设置cookie生命周期，使其失效
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
            }
        }
        //退出后跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/customer/autologin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
