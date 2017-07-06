<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Megashop</title>

<!--js-->
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/common.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/ddsmoothmenu.js"></script>
<script src="js/jquery.flexslider.js"></script>
<script src="js/jquery.elastislide.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script src="js/jquery.accordion.js"></script>
<script src="js/light_box.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".inline").colorbox({
			inline : true,
			width : "50%"
		});
	});
</script>
<!--end js-->

<!-- Mobile Specific Metas ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS ================================================== -->

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/orange.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" href="css/elastislide.css" />
<link rel="stylesheet" href="css/home_flexslider.css" />
<link rel="stylesheet" href="css/shopping.css">
<link rel="stylesheet" href="css/light_box.css" />
<link rel="stylesheet" href="css/dd.css" />
<script src="js/dd.js"></script>
<script src="js/shopping.js"></script>
<script src="js/html5.js"></script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<script>
	$(function() {
		$.get("getName", function(result) {
			//alert(result);
			if (result != null) {
				$("#huanying").html("欢迎你，" + result);
				$(".log-in").hide();
				$(".contact-us").hide();
			} else {
				$(".log-in").show();
				$("#tuichu").hide();
			}

		});
		$("#tuichu").on("click", function() {
			$.get("xiaohui", function(result) {
				alert(result);
				location.reload();
			});
		});
	});
		
/* 		$.post("selectcar",function(result){
			 addTable(result);
		}) */
		
/* 		$(".closing").on("click",function(){
			if ($(":checkbox:checked").size() == 0) {
				alert("请选择");
			} else {
				var date =$("#myform").serialize();
				$.post("selectById",date,function(){
					
				})
			}
			}); 
	});*/
	
	
	
/* 	function addTable(result){
		$.each(result,function(index,obj){
			$("#tbody").append('<tr class="shopping-num"><td class="checkbox" style="text-align: right"><input class="check-one check" type="checkbox" /></td>'+
					'<td class="goods"><img src="img/111.jpg" alt="" /> <span>Casio/卡西欧EX-TR350Casio/卡西欧 EX-TR350Casioi</span></td>'+
					'<td class="price1">5999.88</td><td class="count"><span class="reduce"></span> <input class="count-input" type="number" value="1" style="width: 50%; height: 15px;" />'+
					' <span class="add">+</span></td><td class="subtotal" style="color: #ff6600">5999.88</td>'+
					'<td class="operation"><span class="delete">删除</span></td></tr>');
		});
	} */
	
	

		

</script>
</head>
<body>
	<div class="mainContainer sixteen container">
		<!--Header Block-->
		<div class="header-wrapper">
			<header class="container">
				<div class="head-right">
					<ul class="top-nav">
						<li id="huanying"
							style="margin-right: 20px; margin-top: 2px; border-left-width: 0px; border-right-width: 0px;">欢迎你，</li>
						<li class=""><a href="my_order2.html" title="我的订单">我的订单</a></li>
						<li class="my-wishlist"><a href="shopping_cart.html"
							title="我的购物车">我的购物车</a></li>
						<li class="checkout"><a href="common_problem.html"
							title="常见问题">常见问题</a></li>
						<li class="log-in"><a href="log/index.html" title="登录">登录</a></li>
						<li class="contact-us"><a href="register/index.html"
							title="注册">注册</a></li>
						<li id="tuichu"><a>退出</a></li>
					</ul>
					<section class="header-bottom">
						<div class="cart-block">
							<ul>
								<li>(1)</li>
								<li><a href="cart.html" title="Cart"><img title="购物车"
										alt="购物车" src="images/item_icon.png" /></a></li>
								<li>购物车</li>
							</ul>
							<div id="minicart" class="remain_cart" style="display: none;">
								<p class="empty">你的购物车有1个菜品</p>
								<ol>

									<li>
										<div class="img-block">
											<img src="images/small_img.png" title="" alt="" />
										</div>
										<div class="detail-block">
											<h4>
												<a href="#" title="Htc Mobile 1120">辣子鸡</a>
											</h4>
											<p>
												<sanp>￥ 99</sanp>
											</p>
											<a href="#" title="Details">丰富美味</a>
										</div>
										<div class="edit-delete-block">
											<a href="#" title="Edit"><img src="images/edit_icon.png"
												alt="Edit" title="Edit" /></a> <a href="#" title="Remove"><img
												src="images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
										</div>
									</li>
									<li>
										<div class="total-block">
											总价:<span>￥ 99</span>
										</div> <a href="cart.html" title="Checkout" class="orange-btn">结算购买</a>
										<div class="clear"></div>
									</li>
								</ol>
							</div>
						</div>
						<div class="search-block"
							style="margin-left: -130px; width: 420px;">
							<input type="text" placeholder="输入你要搜索的商品" style="width: 350px;" />
							<input type="submit" value="搜索" title="输入你要搜索的商品" />
						</div>
					</section>
				</div>
				<h1 class="logo" style="margin-top: 0px;">
					<a href="index.jsp" title="Logo"> <img title="Logo" alt="Logo"
						src="images/MyLogin.gif" />
					</a>
				</h1>
				<nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
					<ul id="nav">
						<li class="active"><a href="index.html" title="首页">首页</a></li>
						<li class=""><a href="menu.html" title="Shop by">菜谱</a></li>
						<li class=""><a href="about_us.html" title="关于我们">关于我们</a></li>
						<li class=""><a href="#" title="小游戏">小游戏</a></li>
					</ul>
				</nav>
			</header>
		</div>
		<!--Content Block-->
		<section class="content-wrapper">
			<div class="content-container container">
				<div class="col-1-layout">
					<div class="catbox1">
						<table id="cartTable">
							<thead>
								<tr style="border-bottom: 1px solid #ff6600">
									<th class="center"><label> <input
											class="check-all check " type="checkbox" />&nbsp;&nbsp;全选
									</label></th>
									<th class="center">商品</th>
									<th class="center">单价</th>
									<th class="center">数量</th>
									<th class="center">金额</th>
									<th class="center">操作</th>
								</tr>
								<tr>
									<td colspan="5"></td>
								</tr>
							</thead>
							<tbody id="tbody">
								<c:forEach items="${list}" var="list">
								<form id="myform" action="gouwc" method="post">
								<input class="check-one check" type="hidden" value=${list.menu.m_id } name="id"/>
								<input class="check-one check" type="hidden" value=${list.c_id } name="c_id"/>
								<tr class="shopping-num">
									<td class="checkbox" style="text-align: right"><input
										class="check-one check" type="checkbox" value=${list.c_id } name="c_id"/>
										</td>
										
									<td class="goods"><img src="cai/${list.menu.m_img}" alt="" /> <span>${list.menu.m_name }</span></td>
									<td class="price1">${list.menu.m_price }</td>
									<td class="count"><span class="reduce"></span> <input
										class="count-input" type="text" value="1" name="num"
										style="width: 50%; height: 15px;" /> <span class="add">+</span></td>
									<td class="subtotal" style="color: #ff6600">${list.menu.m_price}</td>
									<td class="operation"><span class="delete">删除</span></td>
								</tr>
								
								</c:forEach>
							</tbody>
							
						</table>

						<div class="foot" id="foot" style="position: relative">
							<label class="fl select-all"><input type="checkbox"
								class="check-all check" />&nbsp;&nbsp;全选</label> <a class="fl delete"
								id="deleteAll" href="javascript:;">删除</a>
							<div class="fr closing"><input type="submit" value="结 算" style="font-size:24px;background-color:#eaeaea;border:none;margin-top:10px"></div>
							</form>
							<!--这个结算跳到确认订单-->
							<input type="hidden" id="cartTotalPrice" />
							<div class="fr total">
								合计：￥<span id="priceTotal">0.00</span>
							</div>
							<div class="fr selected" id="selected">
								已选商品<span id="selectedTotal">0</span>件<span class="arrow up">▲</span><span
									class="arrow down"> ▼</span>
							</div>
							<div class="selected-view">
								<div id="selectedViewList" class="clearfix1">
									<div>
										<img src="img/111.jpg"><span>取消选择</span>
									</div>
								</div>
								<span class="arrow">◆<span>◆</span></span>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="news-letter-container">
					<div class="free-shipping-block">
						<h1>享受免费送货</h1>
						<p>消费到一千金额既可成为会员</p>
					</div>
					<div class="news-letter-block">
						<p>网络点餐让生活变得更方便,幸福生活每一天</p>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!--Footer Block-->
	<section class="footer-wrapper">
		<footer class="container">
			<div class="link-block">
				<ul>
					<li class="link-title"><a href="about_us.html" title="关于我们">关于我们</a></li>
					<li><a href="about_us.html" title="关于我们">关于我们</a></li>
				</ul>
				<ul>
					<li class="link-title"><a href="#" title="用户">用户</a></li>
					<li><a href="myuser.html" title="用户信息">用户信息</a></li>
				</ul>
				<ul>
					<li class="link-title"><a href="faq.html" title="常见问题">常见问题</a></li>
					<li><a href="common_problem.html" title="常见问题">常见问题</a></li>
				</ul>
				<ul>
					<li class="link-title">客服电话:4006-888-887</li>
					<li>周一到周五&nbsp;9:00-22:00</li>
					<li>客服电话&nbsp;免费长途</li>
				</ul>
				<ul class="stay-connected-blcok">
					<li>
						<ul class="social-links">
							<li><a data-tooltip="Like us on facebook" href="#"><img
									alt="facebook" src="images/facebook.png"></a></li>
							<li><a data-tooltip="Subscribe to RSS feed" href="#"><img
									alt="RSS" src="images/rss.png"></a></li>
							<li><a data-tooltip="Follow us on twitter" href="#"><img
									alt="twitter" src="images/twitter.png"></a></li>
							<li><a data-tooltip="Follow us on Dribbble" href="#"><img
									alt="dribbble" src="images/dribbble.png"></a></li>
							<li><a data-tooltip="Follow us on Youtube" href="#"><img
									alt="youtube" src="images/youtube.png"></a></li>
							<li><a data-tooltip="Follow us on skype" href="#"><img
									alt="skype" src="images/skype.png"></a></li>
						</ul>
						<div class="payment-block">
							<img src="images/payment.png" alt="payment">
						</div>
					</li>
				</ul>
			</div>
			<div class="footer-bottom-block">
				<p class="copyright-block">菜府点餐网成立已2016年9月份的项目小组作品</p>
			</div>
		</footer>
	</section>
	<div id="leftsead">
		<ul class="list-unstyled">
			<li><a><img src="images/ll04.png" width="131" height="49"
					class="hides" /><img src="images/l04.png" width="47" height="49"
					class="shows" /></a></li>
			<li><a id="top_btn"><img src="images/ll06.png" width="131"
					height="49" class="hides" /><img src="images/l06.png" width="47"
					height="49" class="shows" /></a></li>
		</ul>
	</div>
</body>
</html>