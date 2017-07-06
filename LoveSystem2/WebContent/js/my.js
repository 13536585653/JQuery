function editClick(){
		  
	$("#updateview").modal("show")


}
function addClick(){
	

	$("#addview").modal("show");
	$("#updateview").modal("hide")
}

//查询全部数据
function findAll(){
	$.get("findlist",function(result){
		addTable(result);		
		});
}

//添加表格到页面中
function addTable(result){
	$("#tab tr:not(:first)").empty();
	$.each(result,function(index, obj){
		var type = obj.t_name==undefined ? "" : obj.t_name;
		$("table").append(
	"<tr>"+
		"<td><input type='checkbox' name='bid' value='"+obj.b_id+"'></td>"+
		"<td>"+(index+1)+"</td>"+
		"<td>"+type+"</td>"+
		"<td>"+obj.b_name+"</td>"+
		"<td>"+obj.b_time +"</td>"+  
		"<td><input  alt='"+obj.b_id+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>"+
	"</tr>");
	
	}); 
	buttonClick()
	}

//给添加按钮绑定click事件
function add(){
	$("#add").on("click",function(){	
	$("#f1 :input").val("");
	//显示模式对话框
	$("#addview").modal("show");
	findBookType();
	save();
});
}

//弹出对话框之前将类型信息查询出来绑定到下拉类表中
function findBookType(){
	$.get("findBookType",function(result){
		$("#btype").empty();
		//result绑定到对话框的下拉列表
		$.each(result,function(index,obj){
			$("#btype").append("<option value='"+obj.tid+"'>"+obj.t_name+"</option>");
		})
		
	});
}

//给保存按钮添加事件
function save(){
	$("#save").unbind("click").on("click",function(){
		//序列化表单
		var params=$("#f1").serialize();
		$.post("addBookServlet",params,function(result){
			addTable(result);
		})
	});
}

//给删除按钮添加事件
function del(){
	$("#del").on("click",function(){
		var i=$("#tab :checkbox:checked").size()
		showMessage(i);
		if($("#tab :checkbox:checked").size()==0){
			alert("请选择删除项");}
			else{
				//执行删除操作
				var params=$("#tableForm").serialize();
				//使用ajax提交到后台
				$.post("deleteServlet",params,function(result){
					addTable(result);
				})
			}
	});
}

//给编辑按钮绑定事件
function buttonClick(){
	$("#tab :button").on("click",function(){
		$("#updateview").modal("show");
		//var params=$(this).parent().parent().children().eq(0).children().attr("value");
		//prop方法用于当前元素属性的值，取代attr的方法
		//$.post("updateBook?bid="+params+"",function(result){
		var id=$(this).prop("alt");
		$.post("findBookById",{"bid":id},function(result){
			//将数据添加到数据层中
			$("#bid").val(result.b_id);
			$("#bookName").val(result.b_name);
			$("#createTime").val(result.b_time);
			$("#typeName").empty();
			$.each(result.list,function(index,obj){
				if(result.t_name == obj.t_name){
					$("#typeName").append("<option selected='selected' value='"+obj.tid+"'>"+obj.t_name+"</option>");
				}else{
					$("#typeName").append("<option value='"+obj.tid+"'>"+obj.t_name+"</option>");
					
				}
				
				} )
		});
		update();
		$("#updateview").modal("show");
	
	});
}

//给编辑事件的保存按钮添加事件
function update(){
	$("#update").off("click").on("click",function(){
		//序列化表单
		var params=$("#f2").serialize();
		//提交到后台更新
		$.post("updateBookServlet",params,function(result){
			//更新列表数据
			addTable(result);
		})
	});
}

//显示删除几条数据
function showMessage(message){
    //将错误消息放在账号前面,选择器的before方法可以在当前选中的元素之前放置一些内容
    //添加之前，先将之前的移除掉
    $("#msg").remove();
    $("#tab").before("<div id='msg' class='form-group'><font color='red'>删除了"+message+"条数据</font></div>");
}