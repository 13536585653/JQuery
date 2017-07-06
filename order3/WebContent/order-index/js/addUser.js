// JavaScript Document
//整个表单的切换等...

	
	//验证码
	var changeYzm=function(){
		  document.getElementById
		  ("yzm").src="yzm.jsp?date="+new Date();
	  };
    //注册验证；
    function checkForm() {
        //获取全部表单输入框的值
        var nameVal=$("#nameInput").val();
        var pwdVal=$("#pwdInput").val();
        var addressVal=$("#addressInput").val();
        var emailVal=$("#emailInput").val();
        var phoneVal=$("#phoneInput").val();
        var yzVal=$("#yz").val();
        //正则表达式
        var regName=/^[\u2E80-\u9FFF]+$/;
        var regPwd=/^[a-z0-9_-]{6,18}$/;
        var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        var regPhone=/^1[3|4|5|7|8]\d{9}$/;
            if(nameVal==""||!regName.test(nameVal)){
                alert("用户名输入为空或用户名输入错误！");
                return false;
            }else if(emailVal==""||!regEmail.test(emailVal)){
                alert("邮箱为空或没有按规则填写");
                return false;
            }else if(pwdVal==""||!regPwd.test(pwdVal)){
                alert("密码为空或没有按规则填写");
                return false;
            }else if(addressVal==""||addressVal.length<5){
                alert("地址为空或没有按规则填写");
                return false;
            }else if(phoneVal==""||!regPhone.test(phoneVal)){
                alert("号码为空或没有按规则填写");
                return false;
            }
    }
//清空表单的方法。
function emptyData() {
    $("#nameInput").val("");
    $("#pwdInput").val("");
    $("#addressInput").val("");
    $("#emailInput").val("");
    $("#phoneInput").val("");
    $("#yz").val("");
}

//验证登录时用户名或密码是否为空
 function subcheck(){
 var userName = document.getElementById("userName").value;
 var passwd = document.getElementById("userPwd").value;
 if(userName==""){
 alert("请输入用户名！");
 return false;
 }else if(passwd == ""){
 alert("请输入密码！");
 return false;
 }
 }





