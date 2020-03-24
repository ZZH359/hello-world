package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductGetOneServlet",urlPatterns = "/product/getone")
public class ProductGetOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getById(id);
        if (product !=null){
            request.setAttribute("product",product);
            request.getRequestDispatcher("/product/detail.jsp").forward(request,response);
        }else {
            request.setAttribute("logmsg","未搜到该商品");
            request.getRequestDispatcher("/product/home.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
