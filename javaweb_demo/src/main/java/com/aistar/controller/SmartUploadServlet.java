package com.aistar.controller;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "SmartUploadServlet",urlPatterns = "/test/upload")
public class SmartUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建SmartUpload对象
        SmartUpload smartUpload = new SmartUpload();
        //初始化
        smartUpload.initialize(this.getServletConfig(),request,response);
        System.out.println("=====");
        try {
            smartUpload.upload();  //上传
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        try {
            smartUpload.save("upload");//你要将上传的文件保存到服务器哪个位置
            System.out.println("上传成功");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
