package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductService;
import com.aistar.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ProductModifyServlet",urlPatterns = "/product/modify")
public class ProductModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id01");
        String name = request.getParameter("name");
        String no1 = request.getParameter("no");
        Long no = Long.valueOf(no1);
        String price1 = request.getParameter("price");
        Float price = Float.valueOf(price1);
        String address = request.getParameter("address");
        String color = request.getParameter("color");
        String size1 = request.getParameter("size");
        Float size = Float.valueOf(size1);
        String makedate = request.getParameter("makedate");
        Date date = null;
        date = DateUtil.string2Date(makedate,DateUtil.DATE_PATTERN_YMD);
        Product product = new Product(id,name,no,price,address,color,size,date);

        ProductService productService = new ProductServiceImpl();
        Boolean res = productService.modify(product);
        System.out.println(res);
        request.getRequestDispatcher("/product/getall").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
