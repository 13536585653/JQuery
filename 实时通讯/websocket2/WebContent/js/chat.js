
function chatLoading(target) {
	//1.����WebSocket����,��ָ��URL
	//����������ж�
	if ('WebSocket' in window) {
		ws = new WebSocket(target);
	} else if ('MozWebSocket' in window) {
		ws = new MozWebSocket(target);
	} else {
		alert('WebSocket is not supported by this browser.');
		return;
	}
	
	
	//2.������Ϣ
	$("#send").click(function(){
		ws.send("hello,china") ;
	}) ;
	
	//3.������Ϣ
	ws.onmessage = function(event) {
		var message = $.parseJSON(event.data) ; 
		
		$("#left_top").append("<b style='color:blue'>"+message.info+"</b><br/>") ;
		
		
		
	}
}