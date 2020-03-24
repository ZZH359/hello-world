package com.aistar.controller;

import com.aistar.pojo.Product;
import com.aistar.service.Impl.ProductAjaxServiceImpl;
import com.aistar.service.Impl.ProductServiceImpl;
import com.aistar.service.ProductAjaxService;
import com.aistar.service.ProductService;
import com.aistar.util.DateUtil;
import com.aistar.util.ServerResponse;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ProductAjaxServlet",urlPatterns = "/ajax_product")
public class ProductAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        if (option.equals("getoneproduct")){
            getOne(request,response);
        }else if (option.equals("getallproduct")){
            getAll(request,response);
        }else if (option.equals("addproduct")){
            add(request,response);
        }else if (option.equals("modifyproduct")){
            modify(request,response);
        }else if (option.equals("deleteproduct")){
            delete(request,response);
        }


    }
    private void getOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String getkey = request.getParameter("getkey");
        ProductAjaxService productAjaxService = new ProductAjaxServiceImpl();
        ServerResponse serverResponse = productAjaxService.getById(getkey);
        response.getWriter().println(JSON.toJSONString(serverResponse));

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId =  UUID.randomUUID().toString().replace("-","");
        String proName =request.getParameter("proName");
        String proNumStr =request.getParameter("proNum");
        Long proNum = Long.valueOf(proNumStr);
        String proPriceStr =request.getParameter("proPrice");
        Float proPrice = Float.valueOf(proPriceStr);
        String proAddress =request.getParameter("proAddress");
        String proColor =request.getParameter("proColor");
        String proSizeStr =request.getParameter("proSize");
        Float proSize = Float.valueOf(proSizeStr);
        String proDateStr =request.getParameter("proDate");
        Date proDate = DateUtil.string2Date(proDateStr,DateUtil.DATE_PATTERN_YMD);

        Product product = new Product(proId,proName,proNum,proPrice,proAddress,proColor,proSize,proDate);
        ProductAjaxService productAjaxService = new ProductAjaxServiceImpl();
        ServerResponse serverResponse =productAjaxService.add(product);
        response.getWriter().println(JSON.toJSONString(serverResponse));

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId = request.getParameter("proId");
        ProductAjaxService productAjaxService = new ProductAjaxServiceImpl();
        ServerResponse serverResponse =productAjaxService.delete(proId);
        response.getWriter().println(JSON.toJSONString(serverResponse));

    }
    private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String proId = request.getParameter("proId");
        String proName =request.getParameter("proName");
        String proNumStr =request.getParameter("proNum");
        Long proNum = Long.valueOf(proNumStr);
        String proPriceStr =request.getParameter("proPrice");
        Float proPrice = Float.valueOf(proPriceStr);
        String proAddress =request.getParameter("proAddress");
        String proColor =request.getParameter("proColor");
        String proSizeStr =request.getParameter("proSize");
        Float proSize = Float.valueOf(proSizeStr);
        String proDateStr =request.getParameter("proDate");
        Date proDate = DateUtil.string2Date(proDateStr,DateUtil.DATE_PATTERN_YMD);

        Product product = new Product(proId,proName,proNum,proPrice,proAddress,proColor,proSize,proDate);
        ProductAjaxService productAjaxService = new ProductAjaxServiceImpl();
        ServerResponse serverResponse =productAjaxService.update(product);
        response.getWriter().println(JSON.toJSONString(serverResponse));
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductAjaxService productAjaxService = new ProductAjaxServiceImpl();
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        ServerResponse serverResponse = productAjaxService.getAllByPage(pageNum);
        response.getWriter().println(JSON.toJSONString(serverResponse));
    }








    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


}
