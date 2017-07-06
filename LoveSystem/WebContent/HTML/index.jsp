<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中华慈善捐款</title>
<script type="text/javascript" src="../JS/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../JS/myjs.js"></script>
<link rel="stylesheet" type="text/css" href="../CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../CSS/mycss.css">
<script>
</script>
</head>
<body>
	<center>
		<div style="margin-top:150px;">
			<form>
			<div style="float:right;width:66%;font-size:22px">--中华爱心捐款查询系统<a href="${pageContext.request.contextPath}/HTML/loveAdd.jsp">添加新捐款</a></div>
																				<%-- 因为是转发过来的，所以a标签要跳转的话必须加上转发路径（${pageContext.request.contextPath}），重定向过来的就不用。 --%>
				<table border="1px" width="60%">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>捐款金额（元）</th>
						<th>日期</th>
					</tr>
				
				<c:forEach items="${list }" var="love" varStatus="i">
					<tr>
						<td>${love.lid}</td>
						<td>${love.lname }</td>
						<td>${love.lsex }</td>
						<td>${love.lmoney }</td>
						<td>${love.ltime }</td>
					</tr>
				</c:forEach>	
				</table>
			</form>
		</div>
	</center>
</body>
</html>