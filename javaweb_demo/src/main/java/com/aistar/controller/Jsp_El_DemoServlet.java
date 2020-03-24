package com.aistar.controller;

import com.aistar.pojo.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "Jsp_El_DemoServlet",urlPatterns = "/jsp_el")
public class Jsp_El_DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setAttribute("age","20");
        request.setAttribute("name","Tom");

        session.setAttribute("myDate",new Date());
        request.getRequestDispatcher("jsp_el.jsp").forward(request,response);
        String uuid = UUID.randomUUID().toString();
        session.setAttribute("uuid",uuid);

        //集合List
        Customer customer2 = new Customer(9002,"Walter","abc123");
        Customer customer3 = new Customer(9003,"Allan","abc123");
        List<Customer> custList =  new ArrayList<>();
        custList.add(customer2);
        custList.add(customer3);

        session.setAttribute("myList",custList);


        //Map
        Map<String,Object> map = new HashMap<>();
        map.put("name", "zhangsna");
        map.put("age",18);
        map.put("address","北京..");
        map.put("address","深圳..");
        request.setAttribute("map", map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
