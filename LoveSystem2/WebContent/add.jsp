<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		if("${msg}" != ""){
			if("${msg}" == "捐款成功,谢谢支持,祝你幸福安康"){
				alert("${msg}");
				location.href='findLove';
			}else{
				alert("${msg}");
			}
		}
	}
</script>
</head>
<body onload="check()">
		<form action="addServlet" method="post">
			<table  border="1">
				<tr>
					<td colspan="2" style="float:right;">--捐出一点爱心，托起一片天空</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="lname" value="aaa"/></td>
				</tr>
				<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="lsex" value="男" checked="checked"/>男
				<input type="radio" name="lsex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>捐款日期</td>
			<td><input type="text" name="ltime" value="1999-09-01"/>（yyyy年MM月dd日）</td>
		</tr>
		<tr>
			<td>捐款金额</td>
			<td><input type="text" name="lmoney" value="100"/>（元）</td>
		</tr>
		<tr>
			<td colspan="2"><center><input type="submit" value="提交"/><input type="reset" value="重置"/></center></td>
		</tr>
			</table>
		</form>
</body>
</html>