<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/14
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../customer/autologin" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="userpassword"><br>
    <input type="radio" name="isautologin" value="yes">自动登录 <br>
    <input type="submit" value="登录">
</form>
<%= request.getAttribute("autologinmsg")
%>
</body>
</html>
