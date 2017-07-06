<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table  border=1>
		<tr>
			<td colspan="2" style="float:right;">--中华爱心捐款查询系统 <a href="add.jsp">添加新捐款</a></td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>捐款金额</td>
			<td>日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="love" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>${love.lname }</td>
				<td>${love.lsex }</td>
				<td>${love.lmoney }</td>
				<td>${love.ltime }</td>
				<td>
					<a href="deleteServlet?lid=${love.lid}">删除</a>
					<a href="findLoveById?lid=${love.lid}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>