<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
		<form action="updateServlet" method="post">
		<input type="hidden" value="${love.lid}" name="lid">
			<table  border="1">
				<tr>
					<td colspan="2" style="float:right;">--捐出一点爱心，托起一片天空</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="lname" value="${love.lname}"/></td>
				</tr>
				<tr>
			<td>性别</td>
			<td><c:choose>
					<c:when test="男">
							<input type="radio" name="lsex" checked="checked" value="男"/>男
							<input type="radio" name="lsex" value="女"/>女
					</c:when>
					<c:otherwise>
							<input type="radio" name="lsex" value="男"/>男
							<input type="radio" name="lsex"  checked="checked" value="女"/>女
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		<tr>
			<td>捐款日期</td>
			<td><input type="text" name="ltime" value="${love.ltime}"/>（yyyy年MM月dd日）</td>
		</tr>
		<tr>
			<td>捐款金额</td>
			<td><input type="text" name="lmoney" value="${love.lmoney}"/>（元）</td>
		</tr>
		<tr>
			<td colspan="2"><center><input type="submit" value="提交"/><input type="reset" value="重置"/></center></td>
		</tr>
			</table>
		</form>
</body>
</html>