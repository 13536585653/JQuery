<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>addUserView</title>
<link rel="stylesheet" type="text/css" href="../CSS/addUser.css"/>
<script src="../JS/jquery-1.7.2.js"></script>
<script src="../JS/addUser.js"></script>
<script>
//验证整个表单对错、不为空
function subCheck() {
    if (pwdVal != pwdsVal) {
        alert("！两次输入密码不一致");
        return false;
    }
    
    //判断全部myDiv的显示为"√"时，才可提交表单。
    if (($("#nameDiv").text()=="√")&&($("#pwdDiv").text()=="√")&&($("#pwdDivs").text()=="√")&&($("#sexDiv").text()=="√")&&($("#addressDiv").text()=="√")&&($("#emailDiv").text()=="√")&&($("#phoneDiv").text()=="√")) {
    	return true;
    }else{
    		alert("！没有按规则填写信息");
    }
    
    //调用清空数据的方法
    $("#bto").click(function () {
        emptyData();
    });
  //获取全部表单输入框的值
    var nameVal=$("#nameInput").val();
    var pwdVal=$("#pwdInput").val();
    var pwdsVal=$("#pwdInputs").val();
    var addressVal=$("#addressInput").val();
    var sexVal=$("#sexInput").val();
    var emailVal=$("#emailInput").val();
    var phoneVal=$("#phoneInput").val();
    var yzmVal=$("#captchaInput").val();
	
    if (nameVal == "" || pwdVal == "" || pwdsVal == "" || addressVal == "" || sexVal == "" || emailVal == "" || phoneVal == "" || yzmVal == "") {
        alert("！请把注册表单填写完整");
        return false;
    }else{
    	if("${msg}"!=""){
        	alert("${msg}");
        }
    }
}
</script>
</head>
<body>
<div class="form">
	<div id="landing">登陆</div>
	<div id="registered">注册</div>
	<div class="fix"></div>

	<form action="/take_outSystem/userLogin" method="post">
	<div id="landing-content">
		<div id="photo"><img src="../IMG/photo.jpg" /></div>
		<div class="inp"><input type="text" id="userName" name="userName" placeholder="用户名" /></div>
		<div class="inp"><input type="password" id="userPwd" name="userPwd" placeholder="密码" /></div>
		<div><input class="login" type="submit" value="登录" onclick="return subcheck();"></div>
		<div id="bottom"><span id="registeredtxt"><a href="#">立即注册</a></span><span id="forgotpassword"><a href="#">忘记密码</a></span></div>
	</div>
	</form>
	<div id="registered-content">
		<form  id="addUser" action="/take_outSystem/addUser" method="post">
			<table>
				<tr>
					<td><div class="font1"><font color="#FF0000">*</font>用户名:</div></td>
					<td class="myInput1"><input type="text" name="uname" class="tableinput" id="nameInput" onfocus="nameInput1()" onblur="nameInput2()"/></td>
					<td><div id="nameDiv"  class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>密码:</td>
					<td class="myInput1"><input type="password" name="upwd" class="tableinput" id="pwdInput" onfocus="pwdInput1();" onblur="pwdInput2()"/></td>
					<td><div id="pwdDiv" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>确认密码:</td>
					<td class="myInput1"><input type="password" name="upwd"  class="tableinput" id="pwdInputs" onfocus="pwdInputs1();" onblur="pwdInputs2()"/></td>
					<td><div id="pwdDivs" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1">性别:</td>
					<td class="myInput1"><input type="text" name="usex" class="tableinput" id="sexInput"/></td>
					<td><div id="sexDiv" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>地址:</td>
					<td class="myInput1"><input type="text" name="uaddr" class="tableinput" id="addressInput"/></td>
					<td><div id="addressDiv" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>Email:</td>
					<td class="myInput1"><input type="text" name="uemail" class="tableinput" id="emailInput"/></td>
					<td><div id="emailDiv" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>手机号:</td>
					<td class="myInput1"><input type="text" name="utel" class="tableinput" id="phoneInput"/></td>
					<td><div id="phoneDiv" class="myDiv"></div></td>
				</tr>

				<tr>
					<td class="font1"><font color="#FF0000">*</font>验证码:</td>
					<td class="myInput1"><div><input type="text" class="tableinput2" id="captchaInput" name="yzm"/><div id="captchaDiv"><img id="yzm" src="yzm.jsp"></div></div></td>
                    <td class="font1"><div id="yzm">看不清？<a href="javascript:changeYzm()">换一张</a></div></td>
				</tr>


				<tr>
					<td></td>
					<td class="myDiv"><input type="checkbox" checked class="myInput1">我已阅读并同意条款</td>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td colspan="10"><input id="bto" type="submit" class="tableSubmit" value="注册" onclick="return subCheck()"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>

</html>
