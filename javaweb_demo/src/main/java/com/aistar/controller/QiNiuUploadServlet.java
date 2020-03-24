package com.aistar.controller;

import com.aistar.util.UploadImgUtil;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QiNiuUploadServlet",urlPatterns = "/test/upload")
public class QiNiuUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//（1） SmartUpload 获得页面上传的文件
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(this.getServletConfig(),request,response);

        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        for (int k = 0;k<smartUpload.getFiles().getCount();k++){
            File file = smartUpload.getFiles().getFile(k);
            String filename = file.getFileName();
            byte[] bytes = new byte[file.getSize()];
            for(int i=0;i<bytes.length;i++){
                bytes[i] = file.getBinaryData(i);
            }

            //（2） UploadImgUtil.upload 七牛云工具类 实现上传
            // 依赖于七牛云的工具类 UploadImgUtil.upload 实现上传，不需要smartUpload上传
            String url  = UploadImgUtil.upload(bytes,filename);
            System.out.println(filename);
            System.out.println("url:"+url);
            System.out.println("第"+(k+1)+"张图上传成功上传成功,在七牛云的url：" + url + filename);
        }

        request.setAttribute("uploadmsg","图片上传成功");
        request.getRequestDispatcher("/upload_demo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
