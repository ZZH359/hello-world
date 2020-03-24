package com.aistar.controller;

import com.aistar.pojo.Customer;
import com.aistar.service.CustomerService;
import com.aistar.service.Impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CustomerAutoLoginServlet",urlPatterns = "/customer/autologin")
public class CustomerAutoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpassword");
        String isAutoLogin = request.getParameter("isautologin");
        //执行登录业务
        CustomerService customerService = new CustomerServiceImpl();
        Customer customer = customerService.getByUsernameAndPwd(username,userpwd);
        if (customer==null){
            //登录信息错误，提示错误信息跳转到登陆页面
            request.setAttribute("autologinmsg","用户名或密码错误");
            request.getRequestDispatcher("/customer/autologin.jsp").forward(request,response);
        }else {
            //登录成功，session保存用户信息，跳转到首页显示用户名
            HttpSession session = request.getSession();
            session.setAttribute("logincustomer",customer);
            session.setAttribute("logincustomername",customer.getCustomerName());

            //判断是否勾选自动登录
            if ("yes".equals(isAutoLogin)){
                Cookie autologinCookie = new Cookie("autologincustomer",username+"&"+userpwd);
                autologinCookie.setMaxAge(7*24*60*60);
                autologinCookie.setPath(request.getContextPath());
                response.addCookie(autologinCookie);
            }
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }













    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
