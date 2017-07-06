<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台聊天</title>
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="../js/chat.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/chat.css">
	<script>
		/* $(function(){
				var msg="${serviceMsg}";
				$("#above").append("<br>"+msg+"<br>");
		}); */
		
		$(function(){
		    $(":button").click(function(){
		    var message=$("#msg").val();
		    $("#msg").val("");
		    //将消息异步发送到服务器端
		    $.post("../send",{"msg":message});
		    
		});
		    //去服务器获取消息
		    receive();
		//接受消息的方法
		//发起ajax请求，去服务端找到自己的消息队列，看看有没有消息
		//如果没有，当前的请求线程会阻塞在服务器端，知道队列有消息，
		//会自动响应回来，然后将消息显示在div中。
		//接着又发起请求去服务器端获取，以此不断循环。
		    function receive(){
		    $.get("../receive",function(message){
		    $("#message").append(message+"<br/></br></br>");
		    //递归调用接收方法
		    receive();
		     });
		 }
		});

	</script>
</head>
<body onload="check()">
	<center>
	 <h3>聊天室</h3>
	<div id="body">
		<div id="top">
			<div id="logo">欢迎,<font color="red">${user.getUserName() }</font></div>
			<div id="close">╳</div>
		</div>

	<div id="left">
		<div id="message" style="font-size:20px;text-align:left;overflow:auto">
	</div>
        <div id="center">
        2
    </div>
		<div id="below">
		<div>
    	<input type="text" id="msg" placeholder="请输入您的消息">
		<div id="x">╳</div>
		</div>
        <input type="button" id="bto" value="发送">
	</div>
	</div>
	<div id="right">
	</div>
	</div>
	</center>
</body>
</html>