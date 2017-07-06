<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script src="js/libs/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
</script>


<div class="crumb-wrap">
	<div class="crumb-list">
		<i class="icon-font"></i><a href="index.html">首页</a><span
			class="crumb-step">&gt;</span><span class="crumb-name">系统信息</span>
	</div>
</div>

<div class="result-wrap" style="padding-top: 30px;">
	<table class="result-tab" width="100%">
		<tr>
			<th colspan="2" style="text-align: center;">系统信息</th>
		</tr>
		<tr>
			<th>用户名：${sessionScope.admin.name }</th>
			<th>IP：<%=request.getRemoteAddr()%></th>
		</tr>
		<tr>
			<th>服务器域名：<%=request.getRemoteAddr()%></th>
			<th>脚本解释引擎：Javascript/Jquery</th>
		</tr>
		<tr>
			<th>服务器软件名称：Tomcat v7.0</th>
			<th style="width: 550px;">浏览器版本：<%=request.getHeader("User-agent") %></th>
		</tr>

		<tr>
			<th>Jmail组件：×</th>
			<th >数据库使用： √</th>
		</tr>
	</table>

	<div class="result-wrap"
		style="padding-top: 30px; padding-left: 0px; padding-right: 0px;">
		<table class="result-tab" width="100%">
			<tr>
				<th colspan="2" style="text-align: center;">YUNFANKE.COM(雨点记忆)</th>
			</tr>
			<tr>
				<th>产品开发：</th>
				<th>小燕子</th>
			</tr>
			<tr>
				<th>商业发展：</th>
				<th>雨点记忆</th>
			</tr>
			<tr>
				<th>联系方式</th>
				<th>E-mail：1240557212@qq.com <br>
					QQ：1240557212<br>
					网址：<a>http://yunfanke.win</a>
				</th>
			</tr>
		</table>
	</div>
	<div align="center" style="padding-top: 30px;">
		Copyright 2016 www.yunfake.win<br>
		Poworod By 小燕子<br>
		
	</div>
</div>