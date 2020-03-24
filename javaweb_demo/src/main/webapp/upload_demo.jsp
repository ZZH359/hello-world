<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/19
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form  action ="test/upload" method="post"  enctype="multipart/form-data"  >
    <input type="file" name="myfile" class="myfile" multiple><br>
    <input type="submit" value="提交" class="submitBtn">
</form>
<c:if test="${!empty uploadmsg}">
    <h2><span style="color: green">${uploadmsg}</span></h2>
</c:if>
</body>
</html>
