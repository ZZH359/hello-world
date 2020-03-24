<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/17
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <style>
        .mydiv{
            margin: 0 auto;
            width: 500px;
            height: 800px;
            background-color: rgba(254, 156, 0, 0.56);
            text-align: left;
            font-size: large;
        }
    </style>
</head>
<body>
<div class="mydiv">
    商品_ID :${product.productId}<br>
    商品名称:${product.productName}<br>
    商品编号:${product.productNo}<br>
    商品价格:${product.productPrice}<br>
    商品产地:${product.productAddress}<br>
    商品颜色:${product.productColor}<br>
    商品尺寸:${product.productSize}<br>
    生产日期:<fmt:formatDate value="${product.productMakeDate}" pattern="yyyy-MM-dd" type="date"></fmt:formatDate>
</div>
</body>
</html>
