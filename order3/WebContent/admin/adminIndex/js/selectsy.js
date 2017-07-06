/**
 * 
 */
$(function() {
	$("#selectjx").on("click", function() {
		// 注意：这里返回的result是一个pageBean对象，里面的
		$.get("selectmenu", {"pageNum" : 1}, function(result) {
			// 填充数据
			alert("gfshdjd");
			addTable2(result);
			$('.spinner').spinner();
			$(".spinner").val("1");
			$("html,body").animate({
				scrollTop : $(".mupe").offset().top
			});
			// 分页
			$("#page").pagination(result.rowCount, {
				callback : findPageList,// 点击页码发起的分页查询请求
				items_per_page : result.maxResult,// 每页显示多少条记录
				next_text : ">",// 下一页图标
				prev_text : "<",// 上一页图标
				num_display_entries : 2,// 中间的主体显示页数
				num_edge_entries : 1
			// 边缘显示页数
			});
		});
	});
});

//请求到servlet，
function findPageList(pageNum) {
	$.get("selectmenu", {"pageNum" : ++pageNum}, function(result) {
		addTable2(result);
		$("html,body").animate({
			scrollTop : $(".lck").offset().top
		});
	});
}
	

$(function() {
	$("#selectsy").on("click", function() {
		//alert("fdgfgh");
		// 注意：这里返回的result是一个pageBean对象，里面的
		$.get("selectmenu", {"pageNum" : 1}, function(result) {
			// 填充数据
			addTable2(result);
			$("html,body").animate({
				scrollTop : $(".mupe").offset().top
			});
			// 分页

		});
	});
});


	//遍历所有菜
	function addTable2(result) {
		var i = 0;
		$("#cai").empty();
		$.each(result.list,function(index, obj) {
				$("#cai").append('<div class="mupe"><a href="#" class="lck" id="'
													+ obj.id
													+ '"> <div class="borderbox"><img alt="" src="cai/'
													+ obj.m_fname
													+ '" width="96%" style="display: inline;margin-left:2%;margin-top: 2.5%"> </div></a><div class="contentbox"><div class="header clearfix"><a href="#" class="lck"><h4 class="title">'
													+ obj.m_name
													+ '</h4></a><div class="collected">精选</div></div>  <br/><p>'
													+ obj.tecont
													+ '</p><div class="add-info"><span class="promo">立减10元</span></div></div><div class="pinfo clearfix"><span class="price"><span class="moneyico">¥</span>'
													+ obj.price
													+ '</span><span class="ori-price">价值<span class="price-line">¥<span>'
													+ obj.price
													+ '</span></span></span></div><div class="footer clearfix"><span class="comment">4.5分</span><span class="sold">已售4478</span><div class="bottom-border"></div></div></div></div></div>');
						});
		}

