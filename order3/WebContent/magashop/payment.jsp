
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="js/jquery-1.9.1.min.js"></script>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="css/payment_method.css">
<script>
	function on() {
		var id = document.getElementById("baidulbspay_view_wangyin");
		var id2 = document.getElementById("baidulbspay_view_kuaijie");
		id.style.display = "block";
		id2.style.display = "none";
	}
	function cc() {
		var id = document.getElementById("baidulbspay_view_wangyin");
		var id2 = document.getElementById("baidulbspay_view_kuaijie");
		id.style.display = "none";
		id2.style.display = "block";
	}
	function aa() {
		var id = document
				.getElementById("baidulbspay_pays_other_kuaijiexinyongka");
		var id2 = document.getElementById("baidulbspay_subview_kuaijiechuxuka");
		id.style.display = "block";
		id2.style.display = "none";
	}
	function bb() {
		var id = document
				.getElementById("baidulbspay_pays_other_kuaijiexinyongka");
		var id2 = document.getElementById("baidulbspay_subview_kuaijiechuxuka");
		id.style.display = "none";
		id2.style.display = "block";
	}
</script>

<script type="text/javascript">
	$(function(){
		$(".bg_btn").on("click",function(){
			var val=$('input:radio[name="baidulbspay_pay_name"]:checked').size();
			if(val>0){
				var d=$(".myform").serialize();
				 $.post("update",d,function(result){
				if(result>0){
					location.href="success.jsp?&price= ${price} ";
					alert("付款成功");
					}
				}); 
				return false;
			}
			alert("请选择一种支付方式")
		});
					

			
	});
</script>
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
</head>
<body>
	<div
		style="position: relative; height: 50px; background-color: #ff6600">
		<div
			style="padding-top: 10px; color: #fff; font-size: 25px; margin-left: 100px;">
			<strong>菜府支付</strong>
		</div>
	</div>
	<div class="pay_main">
		<div class="w-order-nav">
			<a class="logo" target="_blank" href="#"></a>
			<div class="nav-wrap ">
				<div class="stepInfo" style="float: right; margin-top: 40px;">
					<ul>
						<li></li>
						<li></li>
					</ul>
					<div class="stepIco stepIco1" id="create">
						1
						<div class="stepText" id="createText">确认订单</div>
					</div>
					<div class="stepIco stepIco2" id="check"
						style="background-color: firebrick">
						2
						<div class="stepText" id="checkText">支付方式</div>
					</div>
					<div class="stepIco stepIco3" id="produce">
						3
						<div class="stepText" id="produceText">支付成功</div>
					</div>
				</div>
			</div>
		</div>
		<div class="order_infor_module">
			<div class="order_details">
				<table width="100%">
					<tbody>
						<tr class="clearfix">
							<td class="fl_left ">
								<ul class="order-list">
									<li><span class="order-list-no">订单1:</span> <span
										class="order-list-name">${name}</span><span
										class="order-list-number">&nbsp${num}份</span></li>
								</ul>
							</td>
							<td class="fl_right">
								<dl class="clearfix">
									<dd>
										应付金额：<span class="money">${price}</span>
									</dd>
								</dl>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="pay_module">
		<div id="fancybox-wrap">
			<div class="fancybox-skin">
				<div class="fancybox-inner"
					style="overflow: hidden; width: 628px; height: 280px;">
					<iframe src="" frameborder="0" id="alipayQrIframe"
						style="width: 628px; height: 280px; overflow: hidden; display: none"></iframe>
				</div>
				<a title="Close" class="fancybox-close" id="fancybox-close"></a>
			</div>
		</div>

		<div class="payment_way" id="pay">

			<div class="baidulbspay--box  has-recent " id="baidulbspay_box"
				style="zoom: 1;">
				<form class="myform">
				<input type="hidden" name="number" value="${number}">
				<div class="payschoice" style="zoom: 1;">
					<h1 class="title">选择支付方式</h1>
					<ul class="pays-list">
						<li><a id="baidulbspay_tab_pingtai"
							class="view-switcher selected">
								<h1 class="pays-name">账户支付</h1> <span class="tip tip-rec">以下支付更安全</span>
						</a>
							<div id="baidulbspay_view_pingtai" class="pay-view">
								<div id="baidulbspay_form_pingtai" class="form">
									<div class="pays">
										<div class="paylist">
											<div class="line" id="baidulbspay_pingtai_recent">
												<div class="pay " style="position: relative">
													<input type="radio" id="baidulbspay5"
														value="货到付款"
														name="baidulbspay_pay_name" class="radio"> <label
														class="img " for="baidulbspay5" id="baidulbspay5_label">&nbsp;&nbsp;&nbsp;&nbsp;货到支付
														<div class="kuaijie"></div>
													</label>
												</div>
												<div class="pay " style="position: relative">
													<input type="radio" id="baidulbspay3"
														value="支付宝" name="baidulbspay_pay_name"
														class="radio"> <label class="img "
														for="baidulbspay3" id="baidulbspay3_label"><div
															class="logo" style="background-position: 0px -2079px;"></div>
														<div class="kuaijie"></div></label>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div></li>
						<li><a id="baidulbspay_tab_wangyin" onclick="on()"
							href="javascript: void(0);" class="view-switcher">
								<div class="state-arrow"></div>
								<h1 class="pays-name">
									银行网银支付<span class="detail">(储蓄卡或者信用卡)</span>
								</h1> <span class="tip">推荐开通网上银行的用户使用</span>
						</a>

							<div id="baidulbspay_view_wangyin" style="display: none;"
								class="pay-view">
								<div id="baidulbspay_form_wangyin" class="form">
									<div class="pays">
										<div class="paylist">
											<div class="main " id="baidulbspay_pays_other_wangyin">
												<div class="line">
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-ICBC" id="baidulbspay9"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay9" id="baidulbspay9_label"><div
																class="logo" style="background-position: 0px -999px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-CCB" id="baidulbspay10"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay10" id="baidulbspay10_label"><div
																class="logo" style="background-position: 0px -1755px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-ABC" id="baidulbspay11"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay11" id="baidulbspay11_label"><div
																class="logo" style="background-position: 0px 0px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-PSBC" id="baidulbspay12"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay12" id="baidulbspay12_label"><div
																class="logo" style="background-position: 0px -621px;"></div>
															<div class="kuaijie"></div></label>
													</div>
												</div>
												<div class="line">
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-BOCM" id="baidulbspay13"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay13" id="baidulbspay13_label"><div
																class="logo" style="background-position: 0px -54px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-CMB" id="baidulbspay14"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay14" id="baidulbspay14_label"><div
																class="logo" style="background-position: 0px -1593px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-BOC" id="baidulbspay15"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay15" id="baidulbspay15_label"><div
																class="logo" style="background-position: 0px -1863px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-CEB" id="baidulbspay16"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay16" id="baidulbspay16_label"><div
																class="logo" style="background-position: 0px -1674px;"></div>
															<div class="kuaijie"></div></label>
													</div>
												</div>
												<div class="line">
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-ECITIC"
															id="baidulbspay17" name="baidulbspay_pay_name"
															class="radio"> <label class="img"
															for="baidulbspay17" id="baidulbspay17_label"><div
																class="logo" style="background-position: 0px -1620px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-SPDB" id="baidulbspay18"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay18" id="baidulbspay18_label"><div
																class="logo" style="background-position: 0px -675px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-CMBC" id="baidulbspay19"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay19" id="baidulbspay19_label"><div
																class="logo" style="background-position: 0px -1566px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-CIB" id="baidulbspay20"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay20" id="baidulbspay20_label"><div
																class="logo" style="background-position: 0px -1647px;"></div>
															<div class="kuaijie"></div></label>
													</div>
												</div>
												<div class="line">
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-PAB" id="baidulbspay21"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay21" id="baidulbspay21_label"><div
																class="logo" style="background-position: 0px -702px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-GDB" id="baidulbspay22"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay22" id="baidulbspay22_label"><div
																class="logo" style="background-position: 0px -1296px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-BCCB" id="baidulbspay23"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay23" id="baidulbspay23_label"><div
																class="logo" style="background-position: 0px -1890px;"></div>
															<div class="kuaijie"></div></label>
													</div>
													<div class="pay " style="position: relative">
														<input type="radio" value="BAIDU-BOSH" id="baidulbspay24"
															name="baidulbspay_pay_name" class="radio"> <label
															class="img" for="baidulbspay24" id="baidulbspay24_label"><div
																class="logo" style="background-position: 0px -486px;"></div>
															<div class="kuaijie"></div></label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div></li>
						<li><a id="baidulbspay_tab_kuaijie"
							href="javascript: void(0);" onclick="cc();"
							class="view-switcher selected">
								<div class="state-arrow"></div>
								<h1 class="pays-name">银行卡直接支付</h1> <span class="tip">无需开通网上银行，支持快捷付款</span>
						</a>
							<div id="baidulbspay_view_kuaijie" class="pay-view"
								style="display: none;">
								<div id="baidulbspay_form_kuaijie" class="form">
									<div class="pays">
										<div class="tab-box">
											<ul class="tab-list">
												<li class="tab selected"
													id="baidulbspay_subview_tab_kuaijiexinyongka_li" style="">
													<a href="#" id="baidulbspay_subview_tab_kuaijiexinyongka"
													onclick="aa()" style="color: #666; text-decoration: none">信用卡</a>
												</li>
												<li class="tab "
													id="baidulbspay_subview_tab_kuaijiechuxuka_li"
													style="float: left; margin-left: 10px"><a href="#"
													id="baidulbspay_subview_tab_kuaijiechuxuka" onclick="bb()"
													style="color: #666; text-decoration: none">储蓄卡</a></li>
											</ul>
										</div>
										<div class="all-pays">
											<div class="sub-pays open"
												id="baidulbspay_subview_kuaijiexinyongka">
												<div class="main nodis"
													id="baidulbspay_pays_other_kuaijiexinyongka"
													style="margin-left: 20px;">
													<div class="line">

														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-ICBC"
																id="baidulbspay27" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay27" id="baidulbspay27_label"><div
																	class="logo" style="background-position: 0px -999px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-CCB"
																id="baidulbspay28" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay28" id="baidulbspay28_label"><div
																	class="logo" style="background-position: 0px -1755px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-ABC"
																id="baidulbspay29" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay29" id="baidulbspay29_label"><div
																	class="logo" style="background-position: 0px 0px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-PSBC"
																id="baidulbspay30" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay30" id="baidulbspay30_label"><div
																	class="logo" style="background-position: 0px -621px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-BOCM"
																id="baidulbspay31" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay31" id="baidulbspay31_label"><div
																	class="logo" style="background-position: 0px -54px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-CMB"
																id="baidulbspay32" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay32" id="baidulbspay32_label"><div
																	class="logo" style="background-position: 0px -1593px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-CEB"
																id="baidulbspay33" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay33" id="baidulbspay33_label"><div
																	class="logo" style="background-position: 0px -1674px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-ECITIC"
																id="baidulbspay34" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay34" id="baidulbspay34_label"><div
																	class="logo" style="background-position: 0px -1620px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-SPDB"
																id="baidulbspay35" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay35" id="baidulbspay35_label"><div
																	class="logo" style="background-position: 0px -675px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-CMBC"
																id="baidulbspay36" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay36" id="baidulbspay36_label"><div
																	class="logo" style="background-position: 0px -1566px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-CIB"
																id="baidulbspay37" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay37" id="baidulbspay37_label"><div
																	class="logo" style="background-position: 0px -1647px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-PAB"
																id="baidulbspay38" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay38" id="baidulbspay38_label"><div
																	class="logo" style="background-position: 0px -702px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-GDB"
																id="baidulbspay39" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay39" id="baidulbspay39_label"><div
																	class="logo" style="background-position: 0px -1296px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-BCCB"
																id="baidulbspay40" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay40" id="baidulbspay40_label"><div
																	class="logo" style="background-position: 0px -1890px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPC-BOSH"
																id="baidulbspay41" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay41" id="baidulbspay41_label"><div
																	class="logo" style="background-position: 0px -486px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="sub-pays close"
											id="baidulbspay_subview_kuaijiechuxuka">
											<div class="paylist">
												<div class="main "
													id="baidulbspay_pays_other_kuaijiechuxuka">
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-ICBC"
																id="baidulbspay42" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay42" id="baidulbspay42_label"><div
																	class="logo" style="background-position: 0px -999px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-CCB"
																id="baidulbspay43" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay43" id="baidulbspay43_label"><div
																	class="logo" style="background-position: 0px -1755px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-ABC"
																id="baidulbspay44" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay44" id="baidulbspay44_label"><div
																	class="logo" style="background-position: 0px 0px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-CMB"
																id="baidulbspay45" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay45" id="baidulbspay45_label"><div
																	class="logo" style="background-position: 0px -1593px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-BOC"
																id="baidulbspay46" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay46" id="baidulbspay46_label"><div
																	class="logo" style="background-position: 0px -1863px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-CEB"
																id="baidulbspay47" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay47" id="baidulbspay47_label"><div
																	class="logo" style="background-position: 0px -1674px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-CMBC"
																id="baidulbspay48" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay48" id="baidulbspay48_label"><div
																	class="logo" style="background-position: 0px -1566px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-CIB"
																id="baidulbspay49" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay49" id="baidulbspay49_label"><div
																	class="logo" style="background-position: 0px -1647px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
													<div class="line">
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-GDB"
																id="baidulbspay50" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay50" id="baidulbspay50_label"><div
																	class="logo" style="background-position: 0px -1296px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-BCCB"
																id="baidulbspay51" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay51" id="baidulbspay51_label"><div
																	class="logo" style="background-position: 0px -1890px;"></div>
																<div class="kuaijie"></div></label>
														</div>
														<div class="pay kuaijie" style="position: relative">
															<input type="radio" value="BAIDU-EPD-BOSH"
																id="baidulbspay52" name="baidulbspay_pay_name"
																class="radio"> <label class="img"
																for="baidulbspay52" id="baidulbspay52_label"><div
																	class="logo" style="background-position: 0px -486px;"></div>
																<div class="kuaijie"></div></label>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
				</div>
				</form>
				</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="payment_btn clearfix">
		<input class="bg_btn " style="background-color: #f60" id="submitPay"
			type="submit" value="立即支付">
	</div>
	</div>

	<div class="footer">
		<p>
			使用菜府钱包前必读&nbsp;<a target="_blank" href="#" style="color: #444444">菜府钱包用户协议</a>
		</p>
		<p>
			客服邮箱：wallet-cs@baidu.com &nbsp;官方贴吧：<a target="_blank"
				style="color: #444444" href="#">菜府钱包吧</a>
		</p>
	</div>
</body>

</html>