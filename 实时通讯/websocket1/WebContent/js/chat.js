function chatLoading(target) {
	//浏览器兼容判断
	if ('WebSocket' in window) {
		ws = new WebSocket(target);
	} else if ('MozWebSocket' in window) {
		ws = new MozWebSocket(target);
	} else {
		alert('WebSocket is not supported by this browser.');
		return;
	}
	
	ws.onmessage = function(event) {
		
		var msg = $.parseJSON(event.data) ;
		
		if(msg.info!=undefined) {
			$("#left_top").append(msg.info+"<br/>") ;
		}
		
		if(msg.message!=undefined) {
			$("#left_top").append(msg.message+"<br/>") ;
		}
		
		//清空用户列表并显示登录用户
		$("#right").html("") ;
		$.each(msg.usernameList,function(i,n){
			$("#right").append("<b>"+n+"</b><br/>") ;
		}) ;
	}
}




$(function(){
	
	//发送消息
	$("#send").click(function(){
		var msg = $("#content").val() ;
		$("#content").val("") ;
		
		var cc = $("#right").has(".selectedUser") ;
		var obj = null ;
		
		if(cc.size()==0) {
			//alert("群聊") ;
			obj = {
				type:1 ,
				message:msg
			}
		} else {
			//alert("私聊") ;
			var to = cc.find(".selectedUser").html();
			obj = {
				to:to ,
				type:2 ,
				message:msg
			}
		}
		
		ws.send(JSON.stringify(obj)) ;
		
	}) ;
	
	
	//选择私聊的用户 
	$("#right").on("click","b",function(){
		$(this).siblings().removeClass("selectedUser") ;
		if($(this).prop("class")!="selectedUser") {
			$(this).addClass("selectedUser") ;
		} else {
			$(this).removeClass("selectedUser") ;
		}
	}) ;
	
	
	
}) ;

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
	ws.close() ;
}

