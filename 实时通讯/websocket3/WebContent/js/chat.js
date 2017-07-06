
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
		
		var obj = null ;
		
		//拿到这个节点的数量
		/**
		 * 在right节点中,查找.selectedUser选择器,并获取它的大小
		 *为了实现私聊做准备的,如果当前size是1的话,
		 */
		var size = $("#right").find(".selectedUser").size() ;
		
		//拿到当前点击的节点名称,为了实现私聊,知道是和谁了
		var username = $("#right").find(".selectedUser").html() ;
		
	
		
		//获取文本框中的数据
		var content = $("#content").val() ;
		
		//私聊
		if(size==1) {//拿到当前被点击的用户
			obj = {
				to:username ,		//给谁发
				type:2 ,			//状态为2,是私聊的意思
				message:content		//要发送的内容
			}
		} else {
			obj = {
				type:1 ,			//状态为1,是群发
				message:content		//要发送的内容
			}
		}
		
		//ws.send(obj) ;
		//var json字符串 = JSON.stringify(json对象)
		
		//把一个json对象转换成一个json格式的字符串
		ws.send(JSON.stringify(obj)) ;//js中的方法,一定要这样转,因为不转,服务器拿到的是一个[Object Object]对象
		
		$("#content").val("") ;//清空文本框的值
		$("#content")[0].focus() ;//获取焦点
		
		
		
	}) ;
	
	//3.接收消息
	ws.onmessage = function(event) {
		//接收服务器响应的数据
		var messageObj = $.parseJSON(event.data) ; 
		
		//alert("-->"+messageObj.message);
		
		//显示登录或退出信息
		if(messageObj.info!=undefined) {
			$("#left_top").append("<b style='color:blue'>"+messageObj.info+"</b><br/>") ;
		}
		
		//显示消息
		if(messageObj.message!=undefined) {
			$("#left_top").append("<b style='color:black'>"+messageObj.message+"</b><br/>") ;
		}
		
		//alert("OK?") ;
			
		$("#right").html("") ;
		
		//显示用户列表
		$.each(messageObj.usernameList,function(i,name){
			$("#right").append("<p>" + name + "</p>") ;
		}) ;
	}
}




$(function(){
	//选择私聊的用户
	/**
	 * 当单击right节点下的p标签时,除了当前节点,其他所有节点带selectedUser都清空
	 * 点击P节点时,没有就添加这个选择器,有就移除
	 */
	$("#right").on("click","p",function(){
		//alert($(this).html()) ;
		$(this).siblings().removeClass("selectedUser") ;
		
		$(this).toggleClass("selectedUser") ;
	}) ;
}) ;










