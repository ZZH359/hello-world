package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductService;
import com.github.pagehelper.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductGetAllByPageServlet",urlPatterns = "/product/getallbypage")
public class ProductGetAllByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String pageNumStr = request.getParameter("page");
       Integer pageNo = 0;
       if (pageNumStr ==null){
           pageNo=1;
       }else {
           pageNo=Integer.valueOf(pageNumStr);
       }
        ProductService service =  new ProductServiceImpl();
        Page<Product> page= service.getAllByPage(pageNo);

        request.setAttribute("total",page.getTotal());
        request.setAttribute("pageNum",page.getPageNum());
        request.setAttribute("pages",page.getPages());
        request.setAttribute("productList",page.getResult());

        request.getRequestDispatcher("/product/all_page.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
