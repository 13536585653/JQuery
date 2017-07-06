<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chat</title>
<script src="../js/jquery-1.7.2.js"></script>
<script  type="text/javascript" src="../js/chat.js"></script>
</head>
<body>
<h2>登录前台聊天室</h2>
<form action="../userLoginServlet" method="post">
<p>用户名:<input type="text" name="userName">
<p><input type="submit" value="提交">
</form>
</body>
</html>