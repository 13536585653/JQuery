
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="js/jquery-1.9.1.min.js"></script>
<html lang="en">
    <meta charset="UTF-8">
    <title>Title</title>
<link href="css/successful_payment.css" rel="stylesheet">
<script type="text/javascript">
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
    var xx = $.getUrlParam('price');
    
    add(xx);

    $.get("getName",function(result){
    		if(result==null){		
    		$("#log-in").show();
    		$("#contact-us").show();
    		$("#tuichu").hide();
    		}else{
    			$("#huanying").html("欢迎你，"+result);
    			$("#log-in").hide();
    			$("#contact-us").hide();
    			
    		}
    		
    	
    	});
    $("#tuichu").on("click",function(){
    	$.get("xiaohui",function(result){
    		alert(result);
    		location.reload();
    	});
    });
  
   
});
function add(xx){
	$("#price").append('<em style="color:#b10000;font-weight: bolder;" >'+xx+'</em>');
}
</script>
</head>
<body >
<div style="height: 40px;text-align:right;background-color:#f5f5f5;width: auto;white-space:nowrap;position: relative">
        <div style="border: 1px solid #f5f5f5;height:20px;position: relative;color: #666;font-size: 13px;">
            <ul style="margin-right:130px;">
                <li class="yang"><a href="my_order.html">我的订单</a></li>
                <li class="yang"><a href="shopping_cart.html">我的购物车</a></li>
                <li class="yang"><a href="about_us.html">常见问题</a></li>
                <li class="yang" id="log-in"><a href="log/index.html">登录</a></li>
                <li style="display:inline" id="contact-us"><a href="register/index.html">注册</a></li>
            </ul>
        </div>
</div>
<div style="width: 200px;margin-left: 200px;">
       <a href="index.jsp"> <img src="images/MyLogin.gif" height="60px;"></a>
    </div>
<div style="width: 1000px;position: relative;margin-left: 15%;margin-top: -20px;">
<div id="main">
    <div id="J_AmountList" class="take-delivery" style="white-space:nowrap;">
        <h2>您已成功付款</h2>
        <div class="summary-status summary-paydone" >
            <ul >
                <li >收货地址：<span>${sessionScope.User.uaddr }&nbsp${sessionScope.User.uname }&nbsp${sessionScope.User.utel }</span></li>
                <li>实付款：<span id="price"></span></li>
                <li><div class="mixture" id="root" style="text-align:left">
                    <div class="mixture" id="div1" style="text-align:left;">
                        <span>预计09月08日送达<span style="color: #949494;"></span></span>
                    </div>
                </div>
                </li>
            </ul>
        </div>
    </div>
    <div id="J_ButtonList">
        <span class="info">您可以</span>
        <a class="J_MakePoint" target="_blank" href="#" data-point-url="undefined">查看已买到的宝贝</a>
        <a class="J_MakePoint" target="_blank" href="#">查看交易详情</a>
    </div>
    <div id="J_RemindList">
        <ul>
            <li class="alert">
    <p>
        <strong>安全提醒：</strong>下单后，
        <span style="color:#c30000;font-weight:bold;">用QQ给您发送链接办理退款的都是骗子</span>
        ！菜府不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
    </p>
                <a href="#" title="$!vo.infoTitle">安心购物，安全无忧，限时赠送100W支付宝账户安全险&gt;&gt;</a>
            </li>
        </ul>
    </div>
    <div id="J_inPeril" style="display:none;"></div>
</div>
</div>

<div class="footer">
    <p>使用菜府钱包前必读&nbsp;<a target="_blank" href="#"style="color: #444444">菜府钱包用户协议</a></p>
    <p>客服邮箱：wallet-cs@baidu.com &nbsp;官方贴吧：<a target="_blank" style="color: #444444" href="#">菜府钱包吧</a></p>
</div>
</body>
</html>