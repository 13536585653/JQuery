

// ajax请求查出数据，调用渲染菜单方法，显示到页面
/*
 * $(function(){ $("#selectjx").on("click",function(){ //alert("2345678");
 * $.get("findJingxuan",function(result){ addTable(result); }); }); })
 */



// 渲染菜单方法，
function addTable(result) {
	var i = 0;
	$("#cai").empty();
	$.each(result.list,function(index, obj) {
			$("#cai").append('<div class="mupe"><a href="#" class="lck" id="'
												+ obj.id
												+ '"> <div class="borderbox"><img alt="" src="cai/'
												+ obj.m_image
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

	//弹框
	$(".lck").on("click",function() {
						var id = $(this).attr("id");
						alert(id)
						$.get("findJxByid",{"id" : id},function(obj) {
											// alert(id);
											$("#mymodal").empty();
											$("#mymodal")
													.append(
															'<form id="myform" action="selectById" method="post"> <div class="modal-dialog">'
																	+ ' <div class="modal-content"><div class="modal-header" style="border-bottom: none;"><button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button></div>'
																	+ ' <div class="modal-body"><img src="cai/'+ obj.m_image + '" width="200px;"><div style="float: right ;width: 60%;" ><h4 class="title" >'
																	+ obj.m_name
																	+ '</h4><br/><br/>'
																	+ ' <div class="container-fluid">'
																	+ obj.tecont
																	+ '</div> <div class="pinfo clearfix"><span class="price"><span class="moneyico">¥</span>'+obj.price+'</span><span class="ori-price">价值<span class="price-line">¥<span>'+obj.price+'</span></span></span></div>  '
																	+ '<input  type="number" name="num" min="1" default="1"><input type="hidden"  name="id" value="'
																	+ obj.id
																	+ '"></div></div><div class="modal-footer" style="border-top:none;text-align: center"><button type="submit" class="btn btn-default" id="btn1" >购买</button><button type="button" class="btn btn-default" id="btn">加入购物车</button></div></div></form>');

											$("html,body").animate(
													{scrollTop : $(".lck")
																.offset().top
													});
											$("#mymodal").modal("toggle");
											
											/*//购买方法
											$("#btn1").on("click",function() {
												var date=$("#myform").serialize();
												alert(date)
												
											})*/
											
											//加入购物车方法
											$("#btn").on("click",function() {
												var date=$("#myform").serialize();
												alert(date)
												$("#mymodal").modal("hide");
												
											})
											
											
										});

					});
}
