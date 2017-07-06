
function chatLoading(target) {
	//1.创建WebSocket对象,并指定URL
	//浏览器兼容判断
	if ('WebSocket' in window) {
		ws = new WebSocket(target);
	} else if ('MozWebSocket' in window) {
		ws = new MozWebSocket(target);
	} else {
		alert('WebSocket is not supported by this browser.');
		return;
	}
	
	
	//2.发送消息
	$("#send").click(function(){
		ws.send("hello,china") ;
	}) ;
	
	//3.接收消息
	ws.onmessage = function(event) {
		var message = $.parseJSON(event.data) ; 
		
		$("#left_top").append("<b style='color:blue'>"+message.info+"</b><br/>") ;
		
		
		
	}
}