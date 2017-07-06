<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- 弹幕css -->
		<link rel="stylesheet" href="/Shudum/css/danmu.css" />
	<!-- 弹幕css -->
	<!-- 弹幕script -->
	<script type="text/javascript" src="jss/jquery-3.0.0.js" ></script>
	<script type="text/javascript" src="jss/controller.js" ></script>
	<script type="text/javascript" src="jss/model.js" ></script>
	<script type="text/javascript" src="jss/rule.js" ></script>
	<script type="text/javascript" src="jss/view.js" ></script>
	<!-- 弹幕script -->
</head>
<body>
	<div class="button1 blue showBarrage">弹幕</div>
		<div class="barrage">
			<div class="screen">
				<a href="#" class="s_close">X</a>
				<div class="mask">
					<!--内容在这里显示-->
				</div>
			</div>
			<!--Send Begin-->
			<div class="send">
				<input type="text" class="s_text" />
				<div class="button blue s_btn">说两句</div>
			</div>
			<!--Send End-->
			<span class="s_close">X</span>
		</div>
		<!--画布 -->
			<div class="tuxiang">
				<canvas id="myCanvas" class="mainCanvas" width="600" height="600"></canvas>
				<canvas id="new" class="copyCanvas" " width="500" height="500"></canvas>
				<button onclick="copy()">copy</button>
			</div>

		
				
<!-- 判断是否登录-->
	
		<c:choose>
		<c:when test="${uidentity }= guanzhong ">
			<script>
				$(function(){
					$(".mainCanvas").css("display","none");
					$(".copyCanvas").css("dispaly","block");
				})
			</script>
		</c:when>
		<c:when test="${uidentity} = zhubo">
			<script>
				$(function(){
					$(".mainCanvas").css("display","block");
					$(".copyCanvas").css("dispaly","none");
				})
			</script>
		</c:when>
		
		</c:choose>
<!-- 判断是否登录-->

		<!--画布 -->
		<script>
		
		$(function() {
			$(".showBarrage,.s_close").click(function() {
				$(".barrage,.s_close").toggle("slow");
			});
			init_animated();
		})
		//提交评论
	$(".send .s_btn").click(function() {
			var text = $(".s_text").val();
			if(text == "") {
				return;
			};
			var _lable = $("<div style='right:20px;top:0px;opacity:1;color:" + getRandomColor() + ";'>" +"说:"+ text + "</div>");
			$(".mask").append(_lable.show());
			init_barrage();
		})
		//初始化弹幕技术
	function init_barrage() {
		var _top = 0;
		$(".mask div").show().each(function() {
			var _left = $(window).width() - $(this).width(); //浏览器最大宽度，作为定位left的值
			var _height = $(window).height(); //浏览器最大高度
			_top += 75;
			if(_top >= (_height - 130)) {
				_top = 0;
			}
			$(this).css({
				left: _left,
				top: _top,
				color: getRandomColor()
			});
			//定时弹出文字
			var time = 10000;
			if($(this).index() % 2 == 0) {
				time = 15000;
			}
			$(this).animate({
				left: "-" + _left + "px"
			}, time, function() {
				$(this).remove();
			});
		});
	}
	//获取随机颜色
	function getRandomColor() {
		return '#' + (function(h) {
			return new Array(7 - h.length).join("0") + h
		})((Math.random() * 0x1000000 << 0).toString(16))
	}
	visibleCount = 54;
	main();
		</script>
</body>
</html>