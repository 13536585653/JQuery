<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ms登录</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/login.css" rel="stylesheet" />
<script type="text/javascript" src="../jq/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/html5shiv.min.js"></script>
<script type="text/javascript" src="../js/respond.min.js"></script>


<title>Ms 登录</title>
</head>
<body>
	<div id="msloging">

		<div id="mslogin">
			<form method="post">

				<div class="form-group">
					<span id="msregister"><img src="../image/register.png" />&nbsp;&nbsp;登录&nbsp;<b>Msspace</b></b></span>
				</div>

				<div class="form-group">
					<input type="text" class="control" name="username"
						placeholder="请输入昵称" />
				</div>

				<div class="form-group">
					<input type="password" class="control" id="userpass"
						name="userpass" placeholder="请输入密码" />
				</div>

				<div class="form-group">
					<span id="checkboxinput"> <input type="checkbox"
						name="checkboxs" id="checkboxs" checked /><label for="checkboxs">记住密码</label>
						<a href="#" id="forgetpass">忘记密码?</a>
					</span>
				</div>

				<div class="form-group">
					<input type="submit" class="btn control2" value="登录" /> <a
						href="register.jsp" class="btn controls">注册</a>
				</div>
			</form>
		</div>

	</div>
</body>
</html>