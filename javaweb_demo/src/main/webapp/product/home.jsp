<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/17
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品首页</title>
    <style>
        .mydiv{
            margin: 0 auto;
            width: 500px;
            height: 800px;
            background-color: rgba(254, 156, 0, 0.56);
            text-align: center;
        }
        .mydiv input{
            width: 200px;
            height: 40px;
        }
    </style>
</head>
<body>
<div class="mydiv">
    <h2>请输入商品ID进行搜索</h2>
    <form action="/javaweb_demo/product/getone" method="post">
        商品ID:<input type="text" name="id"><br>
        <input type="submit" value="搜索" style="background-color: green"><br>
    </form>

    <c:if test="${!empty logmsg}">
        <p style="color: red;font-size: large">${logmsg}</p>
    </c:if>
    <a href="${pageContext.request.contextPath}/product/getall">查看所有商品</a>
    <a href="${pageContext.request.contextPath}/product/getallbypage">查看所有商品——page</a>
</div>
</body>
</html>
