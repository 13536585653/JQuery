<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.12.3.min.js"></script>
</head>
<body>
	内容：<input type="text" id="txt"/>
	<input type="button" id="con" value="连接"/>
	<input type="button" id="sub" value="提交"/>
	
	<script type="text/javascript">
		//声明一个WebSocket对象
		var ws = null ;
	
		$(function(){
			$("#con").click(function(){
				
				//定义服务器端程序连接地址
				var target = "ws://localhost:8080/websocket/test";	
				
		
				//浏览器兼容判断
				if ('WebSocket' in window) {
					ws = new WebSocket(target);
				} else if ('MozWebSocket' in window) {
					ws = new MozWebSocket(target);
				} else {
					alert('WebSocket is not supported by this browser.');
					return;
				}

			}) ;
			
			
			$("#sub").click(function(){
				//第一：获取文本框中的值
				var text = $("#txt").val() ;
				
				//第二：客户端向服务器发送数据
				ws.send(text) ; 
				
				//name=zs&age=19
				
				$("#txt").val("") ;
				
				ws.onmessage = function(event) {
					alert(event.data) ;
					
				}
			}) ;
			
			
			
			
			
		}) ;
	
	
	</script>
</body>
</html>