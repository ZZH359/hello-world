<%--
  Created by IntelliJ IDEA.
  User: Teng Dong
  Date: 2020/2/12
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
all job!
<hr>
<h4>name:<%=request.getAttribute("name")
            %>
</h4>
<h4>age:<%=request.getAttribute("age")
%>
</h4>
<h4>gender:<%=request.getAttribute("gender")
%>
</h4>
</body>
</html>
