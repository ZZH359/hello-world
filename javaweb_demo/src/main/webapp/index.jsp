<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <h1>完整demo</h1>
    <form action="ueditor/review" method="post">
        标题:<input type="text" name="author"><br>
        内容：<div id="editor" name="content" type="text/plain" style="width:1024px;height:500px;"></div>
        <br> <input type="submit" value="提交游记">
    </form>
</div>




<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>
</body>
</html>
