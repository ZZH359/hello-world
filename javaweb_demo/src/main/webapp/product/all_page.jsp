<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/18
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <style>
        .mydiv{
            margin: 0 auto;
            width: 100%;
            height: 2000px;
            background-color: rgba(254, 156, 0, 0.56);
            text-align: center;
        }
        .ul01 li{
            margin: 0;
            padding: 0;
            width: 220px;
            height: 50px;
            border: 1px solid black;
            display: inline;
            line-height: 40px;
            float:left
        }
        .ul{
            list-style: none;
            text-align: center;
        }
        .ul>li{
            width: 100%;
            height: 50px;

        }
    </style>
</head>
<body>
<div class="mydiv">
    <h1>商品列表</h1>
    <ul class="ul">
        <c:forEach var="product" items="${productList}">
            <li >
                <ul class="ul01" style="list-style: none;">
                    <li><a href="/javaweb_demo/product/getone?id=${product.proId}">${product.proName}</a></li>
                    <li>${product.proNum}</li>
                    <li>${product.proSize}</li>
                    <li>${product.proColor}</li>
                    <li>${product.proPrice}</li>
                    <li><a href="/javaweb_demo/product/delete?id=${product.proId}">删除</a>&nbsp; &nbsp;&nbsp;<a href="/javaweb_demo/product/modifyjump?id=${product.proId}">修改</a></li>
                </ul>
            </li><br>
        </c:forEach>
    </ul>
    <c:if test="${pageNum !=1}">
        <a href="${pageContext.request.contextPath}/product/getallbypage?page=${pageNum-1}">上一页</a>
    </c:if>

    当前是第 <span style="color: red;font-weight: 700" > ${pageNum}</span>页，
    共有<span style="color: red;font-weight: 700" >${pages}</span>页，共有<span style="color: red;font-weight: 700" >${total}</span>条记录，

    <c:if test="${pageNum != pages}">
        <a href="${pageContext.request.contextPath}/product/getallbypage?page=${pageNum+1}">下一页</a>
    </c:if>
</div>
</body>
</html>
