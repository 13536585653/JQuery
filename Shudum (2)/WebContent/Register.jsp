<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
	<head>
	<meta content="html/text; charset=UTF-8" >
		<title>用户注册利用邮箱进行验证</title>  
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="jquery-ui-1.12.0/jquery-ui.min.js"></script>

		<link rel="stylesheet" type="text/css" href="jquery-ui-1.12.0/jquery-ui.min.css" />

		<style type="text/css">
			body {
				background-image: url(img/4.jpg);
			}
			#expire {
				padding: 40px;
				width: 700px;
				height: 400px;
				margin-left: auto;
				margin-right: auto;
				background-color: beige;
				-moz-border-radius: 15px; 
	            -webkit-border-radius: 15px; 
	           	box-shadow: 0 3px 3px rgba(0, 0, 0, 2);
				box-shadow: 0 0 5px black;
			}
			
			input {
				line-height: 38px;
				
			}
			#two{
				margin-right: 23px;
			}
			#date{
				margin-right:23px ;
			}
			input[type='submit'] {
				height: 40px;
				padding: 0 30px;
				font-size: 18px;
				margin: -webkit-calc(5px);
			}
			
			input[type='text'],
			[type='password'] {
				width: 250px;
				height: 30px;
				margin: -webkit-calc(5px);
				position: relative;
				z-index: 10;
				color: #666;
				font-size: 12px;
			}
			input[type="date"]{
				width: 250px;
				height: 30px;
				margin: -webkit-calc(5px);
				position: relative;
				z-index: 10;
				color: #666;
				font-size: 12px;
			}
			input[type='checkbox'] {
				width: 13px;
				height: 13px;
				margin: 0 5px 0 2px;
				cursor: pointer;
				vertical-align: middle;
				padding: 2px;
				margin: -webkit-calc(5px);
			}
			
			#tabs {
				padding: 40px;
				width: 600px;
				height: 450px;
				margin-left: auto;
				margin-right: auto;
				background-color: beige;
				box-shadow: 0 3px 3px rgba(0, 0, 0, 0.5);
			}
		</style>  
  	</head>  
  	<body>  
	    <h1 align="center">数独游戏</h1>
		<div id="expire">
			<h3>新用户注册</h3>
			<form action="/Shudum/YZMYZ" method="post" name="frm">
				<div class="int">
					<span id="two">邮箱:</span><input type="text" id="email"name="email" class="required" placeholder="请输入邮箱" />
				</div>
				<div class="int">
					<span id="two">昵称:</span><input type="text" name="nickname" id="username" class="required" placeholder="请输入用户名" />
				</div>
				<div class="int">
					<span id="two">密码:</span><input type="password" name="password" id="upwd" class="required" placeholder="输入6~13位密码" />
				</div>
				<div class="int">
					性别:&nbsp;&nbsp;
					<input type="radio" name="sex" checked="checked" value="1"/>男&nbsp;&nbsp;
                    <input type="radio" name="sex" value="0"/>女
				</div>
				<br>
				<label for="meeting"><span id="date">生日:</span></label><input id="meeting" type="date" value="2000-01-01"/>
					
				<br>
				验证码：<input type="text" name="YZM" id="" placeholder="不区分大小写" />
				   <input type="button"value="免费获取验证码"id="huo" style="height: 25px;width: 120px;"/>
				   <span id="tishi"></span>
				<br><label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="" id="" value=""checked="checked" /><span style="font-size: 10px;color: #c0c0c9;">同意数独游戏用户协议</span></label>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="" id="" value="立即注册" />
					
			</form>
		</div>
  	
	  	<c:if test="${msg != null}">
			<script>
			/*alert("${email}");*/
				$(function(){
					$("#tishi").text("${msg}").css("color","red");
				});
			</script>
			<c:remove var="msg"/>
	 	</c:if>
	  	<script>
	        $(function(){
	        	$("#huo").on("click",function(){
	        		$.get("/Shudum/RegisterServlet",{email:$("#email").val()},function(resTxt,status,xhr){
	        		/*	if(resTxt=="1")
	        				$("#tishi").text("发送成功");
	        			else
	        				$("#tishi").text("邮箱不存在");*/
	        		});
	        	});
	        });
	        var wait=60;
	        function time(o) {
	        	  if (wait == 0) {
	        	   o.removeAttribute("disabled");   
	        	   o.value="免费获取验证码";
	        	   wait = 60;
	        	  } else { 
	        	 
	        	   o.setAttribute("disabled", true);
	        	   o.value="重新发送(" + wait + ")";
	        	   wait--;
	        	   setTimeout(function() {
	        	    time(o)
	        	   },
	        	   1000)
	        	  }
	        	 }
	        	document.getElementById("huo").onclick=function(){time(this);}
	  </script>
	  <script>
			$(function() {
				$(":input.required").blur(function() {
					//判断一下鼠标离开谁了 
					if($(this).is("#username")) {
						$(".formtip").remove();
						//按照用户名的规则去验证 
						if(this.value == "" || this.value.length < 3) {
							var errMsg = "<span class='formtip'style='color:red;'>用户名至少是3个字符</span>";
							$(this).parent().append(errMsg);
						} else {
							var msg = "<span class='formtip'>用户名可以使用</span>";
							$(this).parent().append(msg);
						}
					}
					if($(this).is("#email")) {
						$(".emailtip").remove();
						//按照email的规则去验证 
						var reg = /^\w{1,}@\w+\.\w+$/;
						var $email = $("#email").val();
						if(!reg.test($email)) {
							var errMsg = "<span class='emailtip' style='color:red;'>邮箱不合法</span>";
							$(this).parent().append(errMsg);
						} else {
							var Msg = "<span class='emailtip'>邮箱可以使用</span>";
							$(this).parent().append(Msg);
						}
					}
					if($(this).is("#upwd")) {
						$(".upwds").remove();
						if(this.value.length>6&&this.value.length<13) {
							var upwda = "<span class='upwds'>密码可以使用</span>";
							$(this).parent().append(upwda);
						} else {
							var upwda = "<span class='upwds'style='color:red;'>密码格式错误</span>";
							$(this).parent().append(upwda);
						}
					}
					if($(this).is("#reupwd")) {
						$(".reupwds").remove();
						if($("#reupwd").val() == $("#upwd").val()) {
							var reupwda = "<span class='reupwds'>可行</sapn>"
							$(this).parent().append(reupwda);
						} else {
							var reupwda = "<span class='reupwds'>密码不一致</span>"
							$(this).parent().append(reupwda);
						}
					}
				});
			});
		</script>
	</body>
</html>  