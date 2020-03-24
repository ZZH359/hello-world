<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/20
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Product-CRUD-Ajax</title>

    <script src="${pageContext.request.contextPath}/jquery/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
    <link rel="stylesheet" href="../css/ajax_product.css" type="text/css">
    <style>
        .modifydiv{
            margin: 0 auto;
            width: 100%;
            height: 500px;
            border-bottom: 2px solid black;
            text-align: center;
        }
        .modifydiv input{
            width: 250px;
            height: 35px;
        }



    </style>
</head>
<body>
<div style="margin: 0 auto;text-align: center;width: 80%;height: 2000px;background-color: #fff69e">

<%--====================================搜索模块============================================--%>
    <h1>搜索模块(Search-Product-Ajax-Json)</h1>
    <%--8fdee7e129fc4d179444e5757e37bad4--%>
    <div class="getdiv">
        <form id="getone-form">
            商品ID:<input type="text" class="getkey" name="getkey"><br>
            <input type="button" class="getbtn" value="搜索" style="background-color: green;width: 300px;color:white;"><br>
        </form>
        <p class="getmsg" style="color: red"></p>
        <h2>商品详情</h2>
        <div class="detail">

        </div>
    </div>

<%--====================================全部商品模块============================================--%>
    <h1>商品列表(Retrieve-Product-Ajax-Json)</h1>
    <div class="alldiv">
        <button class="allbtn">查看全部商品</button>
        <p class="getallmsg" style="color: red"></p>
        <ul class="allul" style="list-style: none;">

        </ul>
        <div class="pagearea">
            <a href="javascript:;" class="prePage">上一页</a>当前页码<span class="pageNum"></span><a href="javascript:;" class="nextPage">下一页</a>&nbsp;&nbsp;共<span class="pages"></span>页、&nbsp;<span class="total"></span>条记录
        </div>
    </div>

<%--====================================添加模块============================================--%>
    <h1>添加模块(Create-Product-Ajax-Json)</h1>
    <div class="adddiv">
        <form id="product-form">
            商品名称:<input type="text" class="proName_add" name="proName"><br>
            商品编号:<input type="text" class="proNum_add" name="proNum"><br>
            商品价格:<input type="text" class="proPrice_add" name="proPrice"><br>
            商品产地:<input type="text" class="proAddress_add" name="proAddress"><br>
            商品颜色:<input type="text" class="proColor_add" name="proColor"><br>
            商品尺寸:<input type="text" class="proSize_add" name="proSize"><br>
            生产日期:<input type="date" class="proDate_add" name="proDate"><br>
            <input type="button" class="addbtn" value="添加商品" style="background-color: green"><br>
        </form>
        <p class="addmsg" style="color: red"></p>
    </div>

<%--&lt;%&ndash;====================================修改模块============================================&ndash;%&gt;--%>
    <h1>修改商品数据</h1>
    <div class="modifydiv">
        <form>
            <input type="hidden" class="proId_modify">
            商品名称:<input type="text" class="proName_modify"><br>
            商品编号:<input type="text" class="proNum_modify"><br>
            商品价格:<input type="text" class="proPrice_modify"><br>
            商品产地:<input type="text" class="proAddress_modify"><br>
            商品颜色:<input type="text" class="proColor_modify"><br>
            商品尺寸:<input type="text" class="proSize_modify"><br>
            生产日期:<input type="date" class="proDate_modify"><br>
            <input type="button" class="modifybtn" value="修改商品" style="background-color: green"><br>
        </form>
        <p class="modifymsg" style="color: red"></p>
    </div>


</div>




<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax_jquery_product.js" charset="UTF-8"></script>
</body>
</html>
