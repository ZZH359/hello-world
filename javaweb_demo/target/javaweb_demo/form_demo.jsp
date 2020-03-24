<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/12
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单获取数据</title>
</head>
<body>
<form action="request_demo" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="userpassword"><br>
    性别：<input type="radio" name="gender" value="nan">男<input type="radio" name="gender" value="nv">女<br>
    爱好：<input type="checkbox" name="like" value="daqiu">打球
    <input type="checkbox" name="like" value="youxi">游戏
    <input type="checkbox" name="like" value="meishi">美食
    <input type="checkbox" name="like" value="lvyou">旅游
    <input type="checkbox" name="like" value="xuexi">学习<br>
    评论：<textarea name="review" style="width: 300px;height: 100px"></textarea><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
