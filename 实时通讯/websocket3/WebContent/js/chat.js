
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
		
		var obj = null ;
		
		//�õ�����ڵ������
		/**
		 * ��right�ڵ���,����.selectedUserѡ����,����ȡ���Ĵ�С
		 *Ϊ��ʵ��˽����׼����,�����ǰsize��1�Ļ�,
		 */
		var size = $("#right").find(".selectedUser").size() ;
		
		//�õ���ǰ����Ľڵ�����,Ϊ��ʵ��˽��,֪���Ǻ�˭��
		var username = $("#right").find(".selectedUser").html() ;
		
	
		
		//��ȡ�ı����е�����
		var content = $("#content").val() ;
		
		//˽��
		if(size==1) {//�õ���ǰ��������û�
			obj = {
				to:username ,		//��˭��
				type:2 ,			//״̬Ϊ2,��˽�ĵ���˼
				message:content		//Ҫ���͵�����
			}
		} else {
			obj = {
				type:1 ,			//״̬Ϊ1,��Ⱥ��
				message:content		//Ҫ���͵�����
			}
		}
		
		//ws.send(obj) ;
		//var json�ַ��� = JSON.stringify(json����)
		
		//��һ��json����ת����һ��json��ʽ���ַ���
		ws.send(JSON.stringify(obj)) ;//js�еķ���,һ��Ҫ����ת,��Ϊ��ת,�������õ�����һ��[Object Object]����
		
		$("#content").val("") ;//����ı����ֵ
		$("#content")[0].focus() ;//��ȡ����
		
		
		
	}) ;
	
	//3.������Ϣ
	ws.onmessage = function(event) {
		//���շ�������Ӧ������
		var messageObj = $.parseJSON(event.data) ; 
		
		//alert("-->"+messageObj.message);
		
		//��ʾ��¼���˳���Ϣ
		if(messageObj.info!=undefined) {
			$("#left_top").append("<b style='color:blue'>"+messageObj.info+"</b><br/>") ;
		}
		
		//��ʾ��Ϣ
		if(messageObj.message!=undefined) {
			$("#left_top").append("<b style='color:black'>"+messageObj.message+"</b><br/>") ;
		}
		
		//alert("OK?") ;
			
		$("#right").html("") ;
		
		//��ʾ�û��б�
		$.each(messageObj.usernameList,function(i,name){
			$("#right").append("<p>" + name + "</p>") ;
		}) ;
	}
}




$(function(){
	//ѡ��˽�ĵ��û�
	/**
	 * ������right�ڵ��µ�p��ǩʱ,���˵�ǰ�ڵ�,�������нڵ��selectedUser�����
	 * ���P�ڵ�ʱ,û�о�������ѡ����,�о��Ƴ�
	 */
	$("#right").on("click","p",function(){
		//alert($(this).html()) ;
		$(this).siblings().removeClass("selectedUser") ;
		
		$(this).toggleClass("selectedUser") ;
	}) ;
}) ;










