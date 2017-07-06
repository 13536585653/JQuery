<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<!--在IE浏览器运行最新的渲染模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--初始化移动浏览显示-设置窗口大小与移动设备一致，且不能缩放窗口-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>聊天室</title>


<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link style="text/css" rel="stylesheet" href="css/style.css"/>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->



</head>
<body>
	


	<div id="header"><h1>欢迎来到南方聊天室</h1></div>
	<div id="container">
		<div id="left">
			<div id="left_top"></div>
			<div id="left_bottom">
				内容：<input type="text" id="content">
				<input type="button" value="发送" id="send" class="btn btn-primary btn-sm"/>
				<input type="button" value="结束" id="over" class="btn btn-primary btn-sm"/>
			</div>
		</div>
		
		<div id="right">
		
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
<script src="js/jquery-1.12.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
<script type="text/javascript">
	var ws = null ;
	
	var username = "${sessionScope.user}" ;
	var target = "ws://localhost:8080/websocket-chat/chatSocket?username=" + username;

	chatLoading(target) ;



</script>
</body>
</html>