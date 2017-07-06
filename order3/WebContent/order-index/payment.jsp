
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".bg_btn").on("click",function(){
			var val=$('input:radio[name="bai"]:checked').size();
			if(val>0){
				var d=$("#table").serialize();
				$.post("update",d,function(result){
				if(result>0){
					location.href="order.jsp?idnum= ${name} &price= ${price} ";
					alert("付款成功");
					}
				});
				return false;
			}
			alert("请选择一种支付方式")
		});
					

			
	});
</script>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/payment.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<div class="container-fluid" id="login"
		style="position: relative; margin-top: 0px;">
		<p class="row">
		<div class="pull-right right">
			<a href="#">登录</a> &nbsp;&nbsp; <a href="#">注册</a>
		</div>
		<div class="pull-right right">
			<a href="myform.html">我的订单</a>&nbsp;&nbsp;&nbsp; <a
				href="shopping.html">我的购物车</a>&nbsp;&nbsp;&nbsp; <a
				href="bangz.html">常见的问题</a>
		</div>
		<div class="col-lg-3" id="colx">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="输入搜索的商品">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button"
						style="color: #aaaaaa">搜索</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<div class="pull-right right">欢迎,******</div>
		</p>
	</div>
	<div class="pay_main">
		<div class="w-order-nav">
			<a class="logo" target="_blank" href="#"></a>
			<div class="nav-wrap "></div>
		</div>
		<div class="order_infor_module">
			<div class="order_details">
				<table width="100%">
					<tbody>
						<tr class="clearfix">
							<td class="fl_left ">
								<ul class="order-list list-unstyled">
									<li><span class="order-list-no">订单号:</span> <span
										class="order-list-name">${name}</span></li>
								</ul>
							</td>
							<td class="fl_right">
								<dl class="clearfix">
									<dd style="float: right; margin-top: 20px; margin-right: 10px;">
										<sanp>应付金额：</sanp>
										<span class="money">${price}</span>
									</dd>
								</dl>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<form id="table">
		<input type="hidden" name="number" value="${name}">
		<div class="container-fluid" style="width: 69.5%;">
			<div style="height: 50px">
				<h1 class="title">选择支付方式</h1>
			</div>
			<div class="view-switcher">
				<h5 style="font-weight: 700; margin-left: 30px;">第三方账号支付</h5>
			</div>
			<div class="line" id="baidulbspay_pingtai_recent"
				style="margin-top: 20px;">
				<div class="pay " style="position: relative">
					<input type="radio" id="baidulbspay2" value="支付宝" name="bai"
						class="radio"> <label class="img " for="baidulbspay2"
						id="baidul"><div class="logo"
							style="background-position: 0px -2079px;"></div>
						<div class="kuaijie"></div></label>
				</div>
				<div class="pay " style="position: relative">
					<input type="radio" id="baidulbspay3" value="微信" name="bai"
						class="radio"> <label class="img " for="baidulbspay3"
						id="baidulbspay3_label"><div class="logo"
							style="background-position: 0px -2107px;"></div>
						<div class="kuaijie"></div></label>
				</div>
			</div>
			<div class="view-switcher">
				<h5 style="font-weight: 700; margin-left: 30px;">货到付款支付</h5>
			</div>
			<div class="pay" style="margin-top: 10px;">
				<input type="radio" id="baidulbspay4" value="到付" name="bai"
					class="radio"> <label class="img " for="baidulbspay3"
					id="baidulbspay3_la"><div
						style="margin-top: 2px; margin-left: 20px;">货到支付</div>
					<div class="kuaijie"></div></label>
			</div>

		</div>
	</form>
	<div class="payment_btn clearfix">
		<input class="bg_btn " id="submitPay" type="button" value="立即支付">
	</div>
	<div class="row"
		style="border: solid 1px #dfdfdf; margin-top: 50px; width: 101.5%; background-color: #fafafa">
		<div class="footer2">
			<div class="footer-size">
				<h4 class="footer-h4">用户帮助</h4>
				<ul class="list-unstyled">
					<li><a href="bangz.html">常见问题</a></li>
				</ul>
			</div>
		</div>
		<div class="footer2">
			<div class="footer-size">
				<h4 class="footer-h4">我的</h4>
				<ul class="list-unstyled">
					<li><a href="#">互动评论</a></li>
					<li><a href="#">会员积分</a></li>
					<li><a href="myuser.htmlser">我的信息</a></li>
				</ul>
			</div>
		</div>
		<div class="footer2">
			<div class="footer-size">
				<h4 class="footer-h4">游戏</h4>
				<ul class="list-unstyled">
					<li><a href="#">打地鼠</a></li>
				</ul>
			</div>
		</div>
		<div class="footer2">
			<div class="footer-size">
				<h4 class="footer-h4">客服电话:4006-888-887</h4>
				<ul class="list-unstyled">
					<li><a href="#">周一到周五&nbsp;9:00-22:00</a></li>
					<li><a href="#">客服电话&nbsp;免费长途</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="site-info">
		<span class="copyright">©</span>2016&nbsp;nuomi.com &nbsp;<a href="#"
			class="link" target="_blank">京ICP证030173号</a>
		&nbsp;京公网安备11010802014106号 &nbsp;<a href="#">营业执照信息</a>
		<div style="width: 300px; margin: 0 auto; padding: 20px 0;">
			<a target="_blank"
				href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000001"
				style="display: inline-block; text-decoration: none; height: 20px; line-height: 20px;"><img
				src="img/a.png" style="float: left;">
				<p
					style="float: left; height: 20px; line-height: 20px; margin: 0px 0px 0px 5px; color: #939393;">京公网安备
					11000002000001号</p></a>
		</div>
	</div>
	<div id="leftsead">
		<ul class="list-unstyled">
			<li><a><img src="img/ll01.png" width="131" height="49"
					class="hides" /><img src="img/l01.png" width="47" height="49"
					class="shows" /></a></li>
			<li><a id="top_btn"><img src="img/ll06.png" width="131"
					height="49" class="hides" /><img src="img/l06.png" width="47"
					height="49" class="shows" /></a></li>
		</ul>
	</div>
</body>
</html>