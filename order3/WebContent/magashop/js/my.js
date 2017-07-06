$(function () {

    //方法二：
    (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    })(jQuery);

    //方法二：
    var xx = $.getUrlParam('id');
    if(xx==null){
    	table2("selectallmenu");
    }else{
    	
    		table("findJingxuan");
    
    }
    
    $.get("findDishes",function(result){
    	dishes(result);
    });

});

function findPageList(pageNum){
	$.get("findJingxuan",{"pageNum":++pageNum},function(result){
		addTable(result);
	});
}

function findPageList2(pageNum){
	$.get("selectallmenu",{"pageNum":++pageNum},function(result){
		addTable(result);
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

function table2(url){
	//注意：这里返回的result是一个pageBean对象，里面的
	$.get(url,{"pageNum":1},function(result){
		//填充数据
		addTable(result);
		//分页
		$("#page").pagination(result.rowCount,{
			callback:findPageList2,//点击页码发起的分页查询请求
			items_per_page:result.maxResult,//每页显示多少条记录
			next_text:"下一页",//下一页图标
			prev_text:"上一页",//上一页图标
			num_display_entries:2,//中间的主体显示页数
			num_edge_entries:1,//边缘显示页数
		});
		
	});
}

function addTable(result){
		$(".new-product-block").empty();
		$.each(result.list, function(key, obj) {
			$(".new-product-block").append('<div class=" mupe" ><a href="javascript:void(0)" class="lck"><div class="borderbox">'+
			'<img alt="" src="cai/'+ obj.m_image + '" width="96%" style="display: inline;margin-left:2%;margin-top: 2.5%">'+
			'</div></a><div class="contentbox"><div class="header clearfix"><a href="javascript:void(0)" class="lck">'+
			'<h4 class="title">【'+obj.m_name+'】</h4></a><div class="collected">精选</div></div><br/><p>'+obj.tecont+'</p>'+
			'</div>'+
			'<div class="pinfo clearfix" ><span class="price"><span class="moneyico">¥</span>'+obj.price+'</span>'+
			'<span class="ori-price">价值<span class="price-line">¥<span>100</span></span></span></div>'+
			'<div class="footer clearfix"><span class="comment">4.5分</span><span class="sold">已售4478</span>'+
			'<div class="bottom-border"></div></div></div>');
			
			
			$(".lck").on("click",function(){
				 $("#qty").val("1");
	             $("#myModal1").modal("toggle");
	            $("html,body").animate({scrollTop:$(".lck").offset().top});
			});
		});
	
}



function dishes(result){
	$.each(result,function(index, obj) {
				$("#dishes").append("<option value='"+obj.d_id+"'>" + obj.d_type);
			});
}