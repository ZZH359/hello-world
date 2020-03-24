<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/17
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>El表达式获取服务器值</h2>
request中的name：${name}<br>
request中的age：${age}<br>
session中的count:${count}<br>

<h1>JSTL</h1>
date:${myDate}
<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd HH-mm-ss" type="date"></fmt:formatDate>

<h2>
    UUID:${uuid}<br>
</h2>
<hr>
${myList}
<c:forEach var="cust" items="${myList}" >
        ${cust.customerId}name:${cust.customerName}<br>
</c:forEach>
<c:if test="false">
    hello
</c:if>


</body>
</html>
