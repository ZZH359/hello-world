<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--====================================搜索模块============================================--%>
<h1>搜索模块(Search-Product-Ajax-Json)</h1>
<div class="getdiv">
    <form>
        商品ID:<input type="text" class="getkey"><br>
        <input type="button" class="getbtn" value="搜索" style="background-color: green;width: 300px;color:white;"><br>
    </form>
    <p class="getmsg" style="color: red"></p>
    <div class="detail">

    </div>
</div>



<script type="text/javascript" src="../js/ajax_product.js" charset="UTF-8"></script>

<h2>Ajax-DEMO</h2>

<a href="javascript:;" class="ajaxdemo1">Ajax请求1</a> <br>
<a href="javascript:;" class="ajaxdemo2">Ajax请求2</a> <br>
<form action="" >
    <input type="text" class="proName"><br>
    <input type="text" class="proNum"><br>
    <input type="text" class="proPrice"><br>
    <input type="text" class="proAddress"><br>
    <input type="button" value="提交" class="ajaxdemo3">
</form>


<script>
    var btn1 = document.querySelector(".ajaxdemo1");
    var btn2 = document.querySelector(".ajaxdemo2");
    var btn3 = document.querySelector(".ajaxdemo3");

    btn3.onclick=function(){
        //1.创建请求
        var xhr = new XMLHttpRequest();
        var proName = document.querySelector(".proName").value;
        var proNum = document.querySelector(".proNum").value;
        var proPrice = document.querySelector(".proPrice").value;
        var proAddress = document.querySelector(".proAddress").value;
        var data = "option=ajaxdemo3&proName="+proName + "&proNum=" + proNum + "&proPrice="+proPrice + "&proAddress="+proAddress;

        //2.open
        xhr.open("POST","/javaweb_demo/ajax_demo",true);
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        //3.
        xhr.onreadystatechange=function (){
            if (xhr.readyState==4){
                if (xhr.status==200){
                    console.log("demo3接收到ajax请求！");
                }
            }

        }
        //4.send
        xhr.send(data);
    }


    btn1.onclick=function () {
        //1.创建请求
        var xhr = new XMLHttpRequest();
        //2.open
        xhr.open("GET","/javaweb_demo/ajax_demo",true);
        //3.
        xhr.onreadystatechange=function (){
            if (xhr.readyState==4){
                if (xhr.status==200){
                    console.log("js接收到ajax请求！");
                }
            }

        }
        //4.send
        xhr.send();
    }
    btn2.onclick=function () {
        //1.创建请求
        var xhr = new XMLHttpRequest();
        //2.open
        // var url = "/javaweb_demo/ajax_demo"
        xhr.open("GET","/javaweb_demo/ajax_demo?option=ajaxdemo2&id=100&name=tom",true);
        //3.
        xhr.onreadystatechange=function (){
            if (xhr.readyState==4){
                if (xhr.status==200){
                    console.log("js接收到ajax请求！");
                }
            }

        }
        //4.send
        xhr.send();
    }



</script>
</body>
</html>
