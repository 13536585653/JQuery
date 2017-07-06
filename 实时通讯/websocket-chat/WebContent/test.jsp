<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<script type="text/javascript">
	
		//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	    window.onbeforeunload = function (event) {
		  var event = event || window.event;
		  // 兼容IE8和Firefox 4之前的版本
		  if (event) {
		    event.returnValue = "确定要关闭窗口吗？";
		  }
		  // Chrome, Safari, Firefox 4+, Opera 12+ , IE 9+
		  return '确定要关闭窗口吗>现代浏览器？';
		}
	
	
	</script>
</body>
</html>