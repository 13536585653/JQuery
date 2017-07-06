<%@ page import="org.order.utils.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>菜府网上点餐后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
   	<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
	<script src="js/libs/jquery-1.7.2.js"></script>
	<link rel="stylesheet" type="text/css" href="../errorUtil/css/xcConfirm.css"/>
	<script src="../errorUtil/js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="../errorUtil/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
	<script>
	
	function mylick(mydiv){
		if($("#"+mydiv).is(":visible")){
			$("#"+mydiv).slideUp(1000);   //由上自下缩短	
			                  }else{
			$("#"+mydiv).slideDown(1000);   //由下自上缩短	
	}
		}

		function add(mydiv){
		var mydiv = document.getElementById(mydiv);
		mydiv.style.display="block";
		}
		function del(myd){
		var mydiv = document.getElementById(myd);
		mydiv.style.display="none";
		}
	</script>
	<script>
	$.fn.extend({ 
		displayPart:function () { 
		var displayLength = 10; 
		displayLength = this.attr("displayLength") || displayLength; 
		var text = this.text(); 
		if (!text) return ""; 

		var result = ""; 
		var count = 0; 
		for (var i = 0; i < displayLength; i++) { 
		var _char = text.charAt(i); 
		if (count >= displayLength) break; 
		if (/[^x00-xff]/.test(_char)) count++; //双字节字符，//[u4e00-u9fa5]中文 

		result += _char; 
		count++; 
		} 
		if (result.length < text.length) { 
		result += "..."; 
		} 
		this.text(result); 
		} 
		}); 

		$(function () { 
		$(".displayPart").displayPart(); 
		}); 
		  
		$(function(){
			  $("#cancelto").click(function(){
				 
					var txt=  "是否要退出,回到登录页面？";
					/* window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.warning); */
					alert(txt);
					location.href="../../adminlogin.html";
			  });
		  });

</script>


<script language="javascript">
function getCurDate()
{
 var d = new Date();
 var week;
 switch (d.getDay()){
 case 1: week="星期一"; break;
 case 2: week="星期二"; break;
 case 3: week="星期三"; break;
 case 4: week="星期四"; break;
 case 5: week="星期五"; break;
 case 6: week="星期六"; break;
 default: week="星期天";
 }
 var years = d.getFullYear();
 var month = add_zero(d.getMonth()+1);
 var days = add_zero(d.getDate());
 var hours = add_zero(d.getHours());
 var minutes = add_zero(d.getMinutes());
 var seconds=add_zero(d.getSeconds());
 var ndate = years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
document.getElementById("m").innerHTML= ndate;
}
function add_zero(temp)
{
 if(temp<10) return "0"+temp;
 else return temp;
}
setInterval("getCurDate()",100);

</script>
</head>
<body >


<div style="width:100%; background-color:#fdfdfd">

&nbsp;&nbsp;&nbsp;<a href="index.html" target="frame"><img src="images/login/2.jpg" width="100px;"height="70px;"/></a>

<div style="width:180px;margin-top:-30px;position: absolute;margin-left:90%;">
<img src="images/login/g.jpg" width="30px;"height="30px;">

<div displayLength="18"  style="width:50px;float:left;height:30px;margin-top:10px;">
${sessionScope.admin.name }
</div>
<div style="width:30px;float:right;height:20px;margin-top:10px;margin-right:60px;"  >
<a href="#" id="cancelto" style="margin-top:10px;">退出</a>
</div>
</div>
<div style="width:30px;float:right;height:50px;margin-top:30px;"  >


</div>

<div style="width:400px;height:30px;margin-left:25%;margin-top:-25px; position: absolute;">
<marquee loop="infinite" id="m" scrolldelay="300"></marquee>
</div>
<div style="text-align:left;width:auto;position: absolute;margin-top:-62px;margin-left:100px;" >
<br/>
<h2 style="font-size:30px;">菜府网上点餐系统</h2>
</div>


<p>
</div>

<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a  href="#" onclick="mylick('d1')"><i class="icon-font">&#xe003;</i>菜单管理</a>
                    <div id="d1" style="width:auto;height:auto;display:none;">
                    <ul class="sub-menu">
                        <li><a href="Dishes.html" target="frame"><i class="icon-font">&#xe008;</i>新增菜谱类型</a></li>
                        <li><a href="select.html" target="frame"><i class="icon-font">&#xe003;</i>所有的菜</a></li>
						<li><a href="select_jingxuan2.html" target="frame"><i class="icon-font">&#xe007;</i>精选菜单</a></li>

			        	</ul>
			     	 </div>
                </li>
                
                <li>
                	<a  href="#" onclick="mylick('d2')"><i class="icon-font">&#xe014;</i>订单管理</a>
                	<div id="d2" style="width:auto;height:auto;display:none;">
                    <ul class="sub-menu">
                    	<li><a href="selectDD3.html" target="frame"><i class="icon-font">&#xe006;</i>订单列表</a></li>
                    	<li><a href="selectDD.html" target="frame"><i class="icon-font">&#xe033;</i>今日订单</a></li>
                    </ul>
                     </div>
                </li>
				
				
                  <li>
                	<a  href="#" onclick="mylick('d3')"><i class="icon-font">&#xe014;</i>用户管理</a>
                	<div id="d3" style="width:auto;height:auto;display:none;">
                    <ul class="sub-menu">
                    	<li><a href="selectmenber.html" target="frame"><i class="icon-font">&#xe032;</i>会员列表</a></li>
                    	<li><a href="selectuser.html" target="frame"><i class="icon-font">&#xe033;</i>用户列表</a></li>
                    </ul>
                     </div>
                 </li>
                 <li>
                	<a  href="#" onclick="mylick('d4')"><i class="icon-font">&#xe014;</i>帮助管理</a>
                	<div id="d4" style="width:auto;height:auto;display:none;">
                    <ul class="sub-menu">
			           	<li><a href="selecthelp2.html" target="frame"><i class="icon-font">&#xe042;</i>帮助中心</a></li>
			            <li><a href="selectwenti.html" target="frame"><i class="icon-font">&#xe001;</i>帮助问题信息</a></li>
                    </ul>
                     </div>
                 </li>
                 
                 <li>
                	<a  href="#" onclick="mylick('d5')"><i class="icon-font">&#xe014;</i>系统管理</a>
                	<div id="d5" style="width:auto;height:auto;display:none;">
                    <ul class="sub-menu">
			           			<li><a href="administered.html" target="frame"><i class="icon-font">&#xe017;</i>修改密码</a></li>
			           			<li><a href="stop.html" target="frame"><i class="icon-font">&#xe017;</i>店铺设置</a></li>
								<li><a href="database.html" target="frame"><i class="icon-font">&#xe046;</i>数据备份</a></li>
								<li><a href="SystemInformation.jsp" target="frame"><i class="icon-font">&#xe045;</i>系统信息</a></li>
                    </ul>
                     </div>
                 </li>
                
                 
               
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
		<iframe name="frame" style="width:99.9%;height:700px;border:0px; float:right;margin-top:-10px;"  src="index.html"></iframe>
     
      
    </div>
    <!--/main-->
</div>
</body>
</html>