<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loveAdd</title>
<script type="text/javascript" src="../JS/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../CSS/mycss.css">
<script type="text/javascript" src="../JS/myjs.js"></script>
	<script>
		
	</script>
</head>
<body>
<center>
	<div style="margin-top:140px">
	<form  action="../addLoveServlet" method="post" >
	<div style="font-size:22px;width:66%;float:right">--捐出一点爱心，托起一片天空</div>
		<table border="1px" width="55%">
			<tr><th class="form" colspan="2" style="height:40px;text-align:center;">中华慈善捐款登记</th></tr>
			<tr>
				<td>姓名：</td>
				<td><input  type="text" class="input" name="lname"></td>
			</tr>
			
			<tr>
				<td>性别：</td>
				<td style="cursor:pointer;"><input type="radio" name="lsex" value="男" checked>男&nbsp;&nbsp;
					<input type="radio" name="lsex" value="女">女
				</td>
			</tr>
			
			<tr>
				<td>捐款日期：</td>
				<td><input type="date" name="ltime">(yyyy年MM月dd日)</td>
			</tr>
			
			<tr>
				<td>捐款金额：</td>
				<td><input type="text" class="input" name="lmoney">(元)</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" onclick="return check()">&nbsp;
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
	</div>
</center>
</body>
</html>