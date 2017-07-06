<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>数独</title>
		<script src="js/jquery.js"></script>
		<script src="js/model.js"></script>
	    <script src="js/view.js"></script>
	    <script src="js/controller.js"></script>
	    <script src="js/rule.js"></script>
	    <script type="text/javascript" src="/Shudum/js/jquery.js" ></script>
		<script type="text/javascript" src="js/title.js" ></script>
		<script type="text/javascript" src="jquery-ui-1.12.0/jquery-ui.min.js"></script>
		<link rel="icon" href="/Shudum/img/main.ico" type="image/x-icon">
		<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.0/jquery-ui.min.css" />
        
		<!-- 	   游戏js -->
		<script type="text/javascript" src="js/game.js" ></script>
		<!--    游戏js-->

    
    	<link rel="stylesheet" href="/Shudum/css/sd.css" />
    	<link rel="stylesheet" href="/Shudum/css/game.css" />
	    
	    
	    <style type="text/css">
	    	*{
	    		margin: 0;
	    		padding: 0;
	    	}
	    	body {
				background-image: url(img/Bbg.jpg);
			}
	    	#sdyx{
	    		
	    		text-align:center;
	    	}
	    	#logo{
	    		border:1px solid black;
	    		width:100%;
	    		height:60px;
	    		background-Color:#FFA240;
	    		line-height:60px;
	    	}
	    	#nd{
	    		width:60px;
	    	}
	    	#dl{
	    		font-size:30px;
	    		padding-left:1100px;
	    		padding-top:20px;
	    		text-decoration:none;
	    	}
	    	#zc{
	    		font-size:30px;
	    		padding-left:10px;
	    		padding-top:20px;
	    		text-decoration:none;
	    	}
	    	.SM{
	    		float:left;
	    		padding:20px;
	    	}
	    	
	    	.SD{
	    	    float:left;
	    	    padding:0;
	    	}
	    	#yxsm{
	    		border:1px solid black;
	    		wight:200px;
	    	}
	    	#accordion{
	    	padding:20px;
	    	width:200px;
	    	height:470px;
	    	font-size:23px;
	    	}
	    	.easy{
	    		margin-top:20px;
	    	}
	    	
	    	#userss{
	    		width: 300px;
	    		
	    	}
	    </style>
	</head>
	<body>
	
	
	
		<!--头部 Start-->
		<div class="sd_header">
			<div class="z_sd_header">
				<div class="sd_header_first">
					 <ul>
						 <!--主站 Start-->
					 	<li class="home">
					 		<a class="all_position" href="index.jsp">
					 			<span>主页</span>
					 		</a>
					 	</li>
					 	<!--主站 End-->
					 	<!--游戏中心 Start-->
					 	<li class="game">
					 		<a class="all_position" href="main.html" title="游戏中心">游戏中心</a>
					 		<div class="game_all" style="display:none">
					 			<iframe src="/Shudum/game.html" frameborder="0" width="100%" height="100%">	
					 			</iframe>
					 		</div>
					 	</li>
					 	<!--游戏中心 End-->
					 	<li class="chat">
					 		<a class="all_position" href="/Shudum/login"  target="_black" title="弹幕聊天室">弹幕聊天室</a>
					 	</li>
					 </ul>
				</div>
				<div class="sd_header_second" id="userss">
					<ul>
						<li class="login">
							<a class="all_position" href="login.html" title="登录">登录</a>
						</li>
						<li class="login">
							<a class="all_position" href="Register.jsp" title="注册">注册</a>
						</li>
					</ul>
				</div>
				<div class="sd_header_second">
					<ul>
						<li class="zh">
							<div class="all_position nc"></div>
						</li>
						<li class="tc">
							<a class="all_position" href="NoLoginServlet">退出登录</a>
						</li>
					</ul>
				</div>
				
					
				
			</div>
		</div>
			
			<div class="bgImg" style="background-image: url(img/bg.jpg);"></div>
	<div class="easy">
	   <form>

			&nbsp;&nbsp;&nbsp;难度选择
			<select id="nd" onchange="chi()">
				<option value="54">容易</option>
				<option value="45">简单</option>
				<option value="36">困难</option>
			</select>
			<button onclick="next()">下一题</button>
		</form>
	</div>	
	<div class="SM">
	<div id="accordion">
      <h3>游戏说明</h3>
       <div>
         <p>
		        <span>1.</span> 数独游戏在9x9的方格内进行，分为3x3的小方格，被称为“区”
			<br><span>2.</span>用1至9之间的数字填满空格，一个格子只能填入一个数字：
			<br><span>3.</span>每个数字在每一行只能出现一次，每个数字在每一列只能出现一次，每个数字在每一区只能出现一次
			
	     </p>
      </div>
 
      </div>
      </div>
		<div class="SD">
		<center><canvas id="myCanvas" width="600" height="600"></canvas></center>
		</div>
		<div class="radio">
			<div class="button blue"><a href="InsertServlet?uidentity=zhubo" target="black">我要直播</a></div>
			<div class="button blue rom" ><a href="InsertServlet?uidentity=guanzhong" target="black">正在直播</a></div>
		</div>
		<c:if test="${nickname != null}">
			<script>
				$(function(){
					$(".nc").text("${nickname}").css({
						"color":"white","font-size":"12px"
					});
					$("#userss").css("display","none");
					$(".tc").css("display","block");
				});
				function add(){
					$("#room").append("<a href=\"danmu.jsp\" class=\"room\"></a>")
				}
			</script>
	 	</c:if>

	 	
		<script type="text/javascript">
			visibleCount = document.getElementById("nd").value;

			
			function next(){
				visibleCount = document.getElementById("nd").value;
				main();
			};
			
			function chi(){
				
				if(visibleCount != document.getElementById("nd").value){
					visibleCount = document.getElementById("nd").value;
					main();
				}
			};
			
			main();
			function zb(){
				var image = new Image();
				image.src = document.getElementById("canvas").toDataURL("image/png");
				document.getElementById("d").src = image;
			}
			function getImg(){
				var canvas = document.getElementById("d");
				canvas.width = image.width;
				canvas.height = image.height;
				canvas.getContext("2d").drawImage(image, 0, 0);
			}
			
		</script>
	</body>
</html>