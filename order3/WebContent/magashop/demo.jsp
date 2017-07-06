<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<!--end js-->

<!-- Mobile Specific Metas ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS ================================================== -->
<link rel="stylesheet" href="css/orderconfirm.css">
<link rel="stylesheet" href="css/tasp.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/orange.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" href="css/elastislide.css" />
<link rel="stylesheet" href="css/home_flexslider.css" />

<link rel="stylesheet" href="css/light_box.css" />
<script src="js/html5.js"></script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
<style>
#page {
	width: auto;
}

#comm-header-inner, #content {
	width: 1000px;
	margin: auto;
}

#logo {
	padding-top: 26px;
	padding-bottom: 12px;
}

#header .wrap-box {
	margin-top: -67px;
}

#logo .logo {
	position: relative;
	overflow: hidden;
	display: inline-block;
	width: 140px;
	height: 35px;
	font-size: 35px;
	line-height: 35px;
	color: #f40;
}

#logo .logo .i {
	position: absolute;
	width: 140px;
	height: 35px;
	top: 0;
	left: 0;
	background: url(http://a.tbcdn.cn/tbsp/img/header/logo.png);
}
</style>

<style type="text/css">
* {
	list-style-type: none;
}

.stepInfo {
	font: 12px/180% Arial, Helvetica, sans-serif, "新宋体";
}

.stepInfo {
	position: relative;
	margin: 10px 20px 0 auto;
	width: 300px;
	height: 30px;
}

.stepInfo li {
	float: left;
	width: 48%;
	height: 0.15em;
	background: #bbb;
}

.stepIco {
	border-radius: 1em;
	padding: 0.03em;
	background: #bbb;
	text-align: center;
	line-height: 1.5em;
	color: #fff;
	position: absolute;
	width: 1.4em;
	height: 1.4em;
}

.stepIco1 {
	top: -0.7em;
	left: -1%;
}

.stepIco2 {
	top: -0.7em;
	left: 48%;
}

.stepIco3 {
	top: -0.7em;
	left: 96%;
}

.stepText {
	color: #666;
	margin-top: 0.2em;
	width: 4em;
	text-align: center;
	margin-left: -1.4em;
}
</style>
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
		$("#tuichu").on("click", function() {
			$.get("xiaohui", function(result) {
				alert(result);
				location.reload();
			});
		});
	});
</script>
</head>
<body data-spm="1">
	<div class="mainContainer sixteen container">
		<!--Header Block-->
		<div class="header-wrapper">
			<header class="container">
			<div class="head-right">
				<ul class="top-nav">	<li class=""><a href="my_order.html" title="我的订单">我的订单</a></li>
					<li class="my-wishlist"><a href="shopping_cart.html"
						title="我的购物车">我的购物车</a></li>
					<li class="checkout"><a href="common_problem.html"
						title="常见问题">常见问题</a></li>
					
				</ul>
				<section class="header-bottom">
				<!-- <div class="cart-block">
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
				</div> -->
				<!-- <div class="search-block" style="margin-left: -130px; width: 420px;">
					<input type="text" placeholder="输入你要搜索的商品" style="width: 350px;" />
					<input type="submit" value="搜索" title="输入你要搜索的商品" />
				</div> -->
				</section>
			</div>
			<h1 class="logo" style="margin-top: 0px;">
				<a href="index.html" title="Logo"> <img title="Logo" alt="Logo"
					src="images/MyLogin.gif" />
				</a>
			</h1>
			<nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
			<ul id="nav">
				<li class="active"><a href="index.html" title="首页">首页</a></li>
				<li class=""><a href="menu.html" title="Shop by">菜谱</a></li>
				
			</ul>
			</nav> </header>
		</div>
		<!--Content Block-->
		<section class="content-wrapper">
		<div class="stepInfo" style="float: right">
			<ul>
				<li></li>
				<li></li>
			</ul>
			<div class="stepIco stepIco1" id="create"
				style="background-color: firebrick">
				1
				<div class="stepText" id="createText">确认订单</div>
			</div>
			<div class="stepIco stepIco2" id="check">
				2
				<div class="stepText" id="checkText">支付方式</div>
			</div>
			<div class="stepIco stepIco3" id="produce">
				3
				<div class="stepText" id="produceText">支付成功</div>
			</div>
		</div>
		<div class="content-container container">

			<div class="main">

				<div class="product-info-box">
					<div class="product-essential">
						<div id="page">

							<div id="content" class="grid-c">

								<div id="address" class="address" style="margin-top: 20px;"
									data-spm="2">
									<form name="addrForm" id="addrForm" action="#">
										<h4 style="font-size: 15px;">
											确认收货地址 <span class="manage-address"> 
											</span>
											<span class="manage-address">
 <a href="#" target="_blank" title="管理我的收货地址"
	class="J_MakePoint" data-point-url="#">管理收货地址</a>
 </span>
										</h4>
										
<ul id="address-list" class="address-list">
										<li class="J_Addr J_MakePoint clearfix  J_DefaultAddr "  data-point-url="http://log.mmstat.com/buy.1.20">
											<s class="J_Marker marker"></s>
											<span class="marker-tip">寄送至</span>
											<div class="address-info">
												<a href="#" class="J_Modify modify J_MakePoint" >修改本地址</a>
												<input name="address"
													   class="J_MakePoint "
													   type="radio"
													   value="674944241"
													   id="addrId_674944241"
													   data-point-url="http://log.mmstat.com/buy.1.20"
													   ah:params="id=674944241^^stationId=0^^address=湖北民族学院（信息工程学院）  男生宿舍楼5栋102^^postCode=445000^^addressee=朱万雄^^phone=^^mobile=18727717260^^areaCode=422801"
													   checked="checked" >
												<label for="addrId_674944241" class="user-address">
													${sessionScope.User.uaddr } (${sessionScope.User.uname } 收) <em>${sessionScope.User.utel }</em>
												</label>
												<em class="tip" style="display: none">默认地址</em>
											</div>
										</li>
										</ul>
									</form>
								</div>
								<form id="myform" name="" action="addOrder" method="post">
									<div>
										<h3 class="dib" style="font-size: 15px;">确认订单信息</h3>
										<table cellspacing="0" cellpadding="0" class="order-table"
											id="J_OrderTable" summary="统一下单订单信息区域">
											<caption style="display: none">统一下单订单信息区域</caption>
											<thead>
												<tr>
													<th class="s-title">店铺宝贝
														<hr />
													</th>
													<th class="s-price">单价(元)
														<hr />
													</th>
													<th class="s-amount">数量
														<hr />
													</th>
													<th class="s-agio">优惠方式(元)
														<hr />
													</th>
													<th class="s-total">小计(元)
														<hr />
													</th>
												</tr>
											</thead>



											<tbody data-spm="3" class="J_Shop" data-tbcbid="0"
												data-outorderid="47285539868" data-isb2c="false"
												data-postMode="2" data-sellerid="1704508670">
												<tr class="shop blue-line">
													<td colspan="2" class="promo">
														<div>
															<ul class="scrolling-promo-hint J_ScrollingPromoHint">
															</ul>
														</div>
													</td>
												</tr>
												<tr class="item"
													data-lineid="19614514619:31175333266:35612993875"
													data-pointRate="0">
													<td class="s-title"><a href="javascript:void(0)" target="_blank"
														class="J_MakePoint"> <img src="cai/${map.m_img }"
															class="itempic"><span class="title J_MakePoint">菜名：${map.m_name }</span></a>
														<div class="props">
															<span>描述：${map.m_description } </span>

														</div>
														<div></div></td>
													<td class="s-price"><span class='price '> <em
															class="style-normal-small-black J_ItemPrice">${map.m_price }</em>
													</span> </td>
													<td class="s-amount" data-point-url=""><input
														type="hidden" class="J_Quantity" value="1" name="" />${map.num }</td>
													<td class="s-agio">
														<div class="J_Promotion promotion" data-point-url="">无优惠</div>
													</td>
													<td class="s-total"><span class='price '> <em
															class="style-normal-bold-red J_ItemTotal ">${map.sum }</em>
													</span>
													</td>
												</tr>
												<tr class="item-service">
													<td colspan="5" class="servicearea" style="display: none"></td>
												</tr>

												<tr class="blue-line" style="height: 2px;">
													<td colspan="5"></td>
												</tr>
												<tr class="other other-line">
													<td colspan="5">
														<ul class="dib-wrap">
															<li class="dib user-info">
																<ul class="wrap">
																	<li>
																		<div class="field gbook">
																			<label class="label">给卖家留言：</label> <input
																				type="text" style="width: 300px; height: 35px;" name="message">
																		</div>
																	</li>
																</ul>
															</li>
															<li class="dib extra-info">
																<div class="shoparea">
																	<ul class="dib-wrap">
																		<li class="dib title">会员优惠：</li>
																		<li class="dib sel"><div
																				class="J_ShopPromo J_Promotion promotion clearfix"
																				data-point-url="http://log.mmstat.com/buy.1.16"></div></li>
																		<li class="dib fee"
																			style="margin-left: 250px; margin-top: -40px;">
																			<span class='price '>-<em class=""
																				style="float: right">${map.jm }</em>
																		</span>
																		</li>
																	</ul>
																</div>
																<div class="shoppointarea"></div>
																<div class="extra-area">
																	<ul class="dib-wrap">
																		<li class="dib title">发货时间：</li>
																		<li class="dib content"
																			style="float: right; margin-top: -40px;">卖家承诺订单在买家付款后，72小时内<a
																			href="#">发货</a></li>
																	</ul>
																</div>
																<div class="servicearea" style="display: none"></div>
															</li>
														</ul>
													</td>
												</tr>

												<tr class="shop-total blue-line">
													<td colspan="5">店铺合计(<span class="J_Exclude"
														style="display: none">不</span>含运费<span
														class="J_ServiceText" style="display: none">，服务费</span>)：
														<span class='price g_price '> <span>&yen;</span><em
															class="style-middle-bold-red J_ShopTotal">${map.sum }</em>
													</span>

													</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<td colspan="5">

														<div class="order-go" data-spm="4">
															<div class="J_AddressConfirm address-confirm">
																<div class="kd-popup pop-back"
																	style="margin-bottom: 40px;">
																	<div class="box">
																		<div class="bd">
																			<div class="point-in">

																				<em class="t">实付款：</em> <span class='price g_price '>
																					<span>&yen;</span><em class="style-large-bold-red"
																					id="J_ActualFee">${map.sum }</em>
																				</span>
																			</div>

																			<ul>
																				<li><em>寄送至:</em><span id="J_AddrConfirm"
																					style="word-break: break-all;"> ${sessionScope.User.uaddr} </span></li>
																				<li><em>收货人:</em><span id="J_AddrNameConfirm">${sessionScope.User.uname } &nbsp ${sessionScope.User.utel } </span></li>
																			</ul>
																		</div>
																	</div>
																	<a href="#" class="back J_MakePoint" target="_top"
																		data-point-url="">返回购物车</a> <input id="J_Go"
																		class=" btn-go" data-point-url="" tabindex="0"
																		title="点击此按钮，提交订单。" type="submit" value="提交订单"><b class="dpl-button"></b></a>
																</div>
															</div>

															<div class="J_confirmError confirm-error">
																<div class="msg J_shopPointError" style="display: none;">
																	<p class="error">积分点数必须为大于0的整数</p>
																</div>
															</div>


															<div class="msg" style="clear: both;">
																<p class="tips naked"
																	style="float: right; padding-right: 0">若价格变动，请在提交订单后联系卖家改价，并查看已买到的宝贝</p>
															</div>
														</div>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>
									<input type="hidden" id="id" name="id" value="${map.id}" /> 
				<input type="hidden" id="num" name="num" value="${map.num}" /> 
				<input type="hidden" id="price" name="price" value="<fmt:formatNumber type="number" value="${map.sum } " maxFractionDigits="2" />" />
				<input type="hidden" id="num" name="name" value="${map.m_name }" /> 
				<input type="hidden" id="c_id" name="c_id" value="${map.c_id }" /> 
								</form>
							</div>

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
	<section class="footer-wrapper"> <footer class="container">
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
	</footer> </section>
</body>

 <script type="text/javascript">
		$(function(){
			$("#J_Go").on("click",function(){
				var params = $("#myform").serialize();
				//alert(params)
			})
		});
</script> 
</html>