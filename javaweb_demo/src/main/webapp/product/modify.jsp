<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/17
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改商品</title>

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
    <h1>修改商品</h1>
    <form action="/javaweb_demo/product/modify" method="post">
        商品__id：<input type="text" name="id01" value="${id}" ><br>
        商品名称:<input type="text" name="name"><br>
        商品编号:<input type="text" name="no"><br>
        商品价格:<input type="text" name="price"><br>
        商品产地:<input type="text" name="address"><br>
        商品颜色:<input type="text" name="color"><br>
        商品尺寸:<input type="text" name="size"><br>
        生产日期:<input type="date" name="makedate"><br>
        <input type="submit" value="修改" style="background-color: green"><br>
    </form>
</div>
</body>
</html>
