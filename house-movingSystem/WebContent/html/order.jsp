<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约搬家系统</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="../css/mycss.css">
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>
</head>
<script>
	$(function(){
		$("#submit").on("click",function(){
			var params=$("#f1").serialize();
			$.post("../order",params,function(result){
				if(result=="预约成功"){
					alert(result);
					location.href="index.jsp";
				}else{
					alert(result);
				}
			});
		});
	});
</script>
<body>
	<!-- 定义一个div容器，bootstrap会针对合格容器内部元素进行布局 -->
	<div class="container" style="width:50%;">
		<!-- form-horizontal表示表单的元素是垂直布局 -->
		<form id="f1" class="form-horizontal">
			<!-- 标题 -->
			<div class="form-group">
				<h1 class="page-header">顺风搬家预约登记<a href="index.jsp" style="float:right;font-size:15px;margin-top:30px;">查看预约</a></h1>
			</div>
			<!--标题2  -->
			<b class="title2">--顺风搬家，一路顺风</b>
			
			<!--起始地区下拉列表  -->
			<div class="form-group">
				<label class="control-label" style="float:left;">起始地区：</label>
				<select name="sel" class="btn btn-default dropdown-toggle">
					<option>西城区</option>
					<option>东城区</option>
					<option>丰台区</option>
					<option>大兴区</option>
					<option>石景山</option>
				</select>
				<!-- <div class="dropdown" style="float:left;">
  		<button class="btn btn-default dropdown-toggle" type="button" id="select" data-toggle="dropdown">
    			请选择
    			<span class="caret"></span>
  		</button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    <li  name="sel" checked><a role="menuitem" tabindex="-1" href="#">海淀区</a></li>
    <li  name="sel"><a role="menuitem" tabindex="-1" href="#">朝阳区</a></li>
    <li><a role="menuitem" tabindex="-1" href="#">西城区</a></li>
    <li><a role="menuitem" tabindex="-1" href="#">东城区</a></li>
    <li><a role="menuitem" tabindex="-1" href="#">丰台区</a></li>
    <li><a role="menuitem" tabindex="-1" href="#">大兴区</a></li>
    <li><a role="menuitem" tabindex="-1" href="#">石景山</a></li>
  </ul>
</div>  -->
			</div>
			<!-- 所用车型 -->
			<div class="form-group" style="cursor:pointer;">
				<label class="control-label" style="float:left;">所用车型：</label>
				<input type="radio" name="radio" value="赛车" checked>赛车&nbsp;&nbsp;
				<input type="radio" name="radio" value="皮卡">皮卡&nbsp;&nbsp;
				<input type="radio" name="radio" value="箱式货车">箱式货车&nbsp;&nbsp;
				<input type="radio" name="radio" value="1041货车">1041货车&nbsp;&nbsp;
				<input type="radio" name="radio" value="火车">火车&nbsp;&nbsp;
			</div>
			
			<!--搬家日期 -->
			<div class="form-group">
				<label class="control-label" style="float:left;">搬家日期：</label>
				<input type="date" name="orderDate" class="form-control" style="width:200px;float:left">
				<div class="dateDiv">&nbsp;&nbsp;日期格式如：2015-02-23</div>
			</div>
			
			<!--联系人  -->
			<div class="form-group">
				<label class="control-label dateDiv" style="float:left;">&nbsp;联&nbsp;系&nbsp;人：</label>
				<div class="dateDiv"><input type="text" name="contacts" class="form-control" style="width:35%"></div>
			</div>
			
			<!--联系电话  -->
			<div class="form-group">
				<label class="control-label dateDiv" style="float:left;">联系电话：</label>
				<div class="dateDiv"><input type="text" name="phone"  style="width:45%" class="form-control" placeholder="手机号/电话"></div>
			</div>
			<!-- 登陆按钮 -->
			<div class="form-group">
				<input id="submit" type="button" class="btn btn-primary btn-lg btn-block" value="预约登记">
			</div>
		</form>
	</div>
</body>
</html>