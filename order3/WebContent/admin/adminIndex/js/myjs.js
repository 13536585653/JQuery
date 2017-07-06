//批量删除的方法
function deleteurl(url,url1) {
	$("#batchDel").on("click", function(result) {
		if ($(":checkbox:checked").size() == 0) {
			alert("请选择");
		} else {
			var date = $("#myform").serialize();
			//alert(date)
			$.post(url, date, function(result) {
				table(url1);
			});
		}
	});
	
}

function deleteurl2(url,url1){
	$(".mydeltet").on("click", function() {
		var id = $(this).attr("name");
		var id1=$(".s").attr("value");
		if(id1!=null){
			$.post(url, {
				"id" : id,"id1" :id1
			}, function(result) {
				table(url1);
			});
		}else{
			$.post(url, {
				"id" : id
			}, function(result) {
				table(url1);
			});
		}
		
	});
}

function table(url){
	//注意：这里返回的result是一个pageBean对象，里面的
	$.get(url,{"pageNum":1},function(result){
		//填充数据
		addTable(result);
		//分页
		$("#page").pagination(result.rowCount,{
			callback:findPageList,//点击页码发起的分页查询请求
			items_per_page:result.maxResult,//每页显示多少条记录
			next_text:"下一页",//下一页图标
			prev_text:"上一页",//上一页图标
			num_display_entries:2,//中间的主体显示页数
			num_edge_entries:1,//边缘显示页数
		});
		
	});
}