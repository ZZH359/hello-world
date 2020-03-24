package com.aistar.controller;

import com.aistar.pojo.Job;
import com.aistar.service.Impl.JobServiceImpl;
import com.aistar.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobGetAllServlet" ,urlPatterns = "/job/getall")
public class JobGetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收页面请求（包含参数）
        // 2.调用service
        JobService jobService= new JobServiceImpl();
        List<Job> jobList = jobService.getAll();
        //3.将数据封装到request
        request.setAttribute("myJobList",jobList);
        request.setAttribute("name","Tom");
        request.setAttribute("age",23);
        request.setAttribute("gender","男");
        //4.跳转到新页面，显示所有职位信息  ---两种方式
        System.out.println("经过服务器查询所有job。。。");
            //1.直接转发 forward
        request.getRequestDispatcher("/job/all.jsp").forward(request,response);
            //2.重定向
//        response.sendRedirect(request.getContextPath()+"/job/all.jsp");//全路径



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
