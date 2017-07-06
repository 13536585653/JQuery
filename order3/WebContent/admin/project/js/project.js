// JavaScript Document

$(function(){
	//账号问题的切换
	$("#zhanghao").click(function(){
		$("#daan1").show();
		$("#daan2").hide();
		$("#daan3").hide();
		$("#daan4").hide();
		$("#daan5").hide();
		});
	//订单相关的切换
	$("#dingdan").click(function(){
		$("#daan1").hide();
		$("#daan2").show();
		$("#daan3").hide();
		$("#daan4").hide();
		$("#daan5").hide();
		});
	//支付相关的切换
	$("#zhifu").click(function(){
		$("#daan1").hide();
		$("#daan2").hide();
		$("#daan3").show();
		$("#daan4").hide();
		$("#daan5").hide();
		});
	//消费问题的切换
	$("#xiaofei").click(function(){
		$("#daan1").hide();
		$("#daan2").hide();
		$("#daan3").hide();
		$("#daan4").show();
		$("#daan5").hide();
		});
	//评价相关的切换
	$("#pingjia").click(function(){
		$("#daan1").hide();
		$("#daan2").hide();
		$("#daan3").hide();
		$("#daan4").hide();
		$("#daan5").show();
		});
	//鼠标移到这里有灰色背景颜色
	$("#zhanghao").hover(
		function () {
				$(this).addClass("hover");
			  },
			  function () {
				$(this).removeClass("hover");
		});
	//鼠标移到这里有灰色背景颜色
	$("#dingdan").hover(
		function () {
				$(this).addClass("hover");
			  },
			  function () {
				$(this).removeClass("hover");
		});
	//鼠标移到这里有灰色背景颜色
	$("#zhifu").hover(
		function () {
				$(this).addClass("hover");
			  },
			  function () {
				$(this).removeClass("hover");
		});
	//鼠标移到这里有灰色背景颜色
	$("#xiaofei").hover(
		function () {
				$(this).addClass("hover");
			  },
			  function () {
				$(this).removeClass("hover");
		});
	//鼠标移到这里有灰色背景颜色
	$("#pingjia").hover(
		function () {
				$(this).addClass("hover");
			  },
			  function () {
				$(this).removeClass("hover");
		});
	
	
	});
	
	