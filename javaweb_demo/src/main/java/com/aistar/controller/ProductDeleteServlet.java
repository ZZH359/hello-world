package com.aistar.controller;

import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDeleteServlet",urlPatterns = "/product/delete")
public class ProductDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProductService productService = new ProductServiceImpl();
        Boolean res = productService.delete(id);
        request.getRequestDispatcher("/product/getall").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
