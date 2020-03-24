<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/13
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/javaweb_demo/customer/login" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="userpassword">
    <input type="submit">
</form>
<%=request.getAttribute("loginMessage")
%>
</body>
</html>
