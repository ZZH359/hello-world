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
import java.util.List;

@WebServlet(name = "ProductGetAllServlet",urlPatterns = "/product/getall")
public class ProductGetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> productList = productService.getAll();
        request.setAttribute("productList",productList);
        request.setAttribute("aaa","bbb");
        request.getRequestDispatcher("/product/all.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
