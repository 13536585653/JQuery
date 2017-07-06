<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约菜单</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="../css/mycss.css">
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>

<script>
	$(function(){
		$(":button").on("click",function(){
			location.href="order.jsp";
		});
	});
</script>
</head>
<body>
	<div class="container" style="width: 50%;">
    		<h1 class="page-header">顺风搬家预约登记</h1>
    		<!--标题2  -->
			<b class="title2">--顺风搬家，一路顺风</b>
    <input type="button" id="add" class="btn btn-primary" value="预约">
    <form id="tableForm">
    <table id="tab" class="table table-bordered table-hover">
        <tr id="header">
            <th>起始地区</th>
            <th>所用车型</th>
            <th>搬家日期</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>状态</th>
        </tr>
        
        <c:forEach items="${list}" var="house" varStatus="i">
        
        <tr>
        	<td>${house.harea}</td>
        	<td>${house.hcartype}</td>
        	<td>${house.hmovedate}</td>
        	<td>${house.hcontact}</td>
        	<td>${house.hphone}</td>
        	<td><c:if test="${house.hstatus==0}">
        	未处理 
        	</c:if></td>
        </tr>
        </c:forEach>
    </table>
    </form>
</div>
</body>
</html>