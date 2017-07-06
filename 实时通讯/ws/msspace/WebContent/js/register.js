$(document).ready(function(){
	$("#username").blur(function(){
		var $frm = $("#registerform").serialize();
		$.ajax({
			url:"UserInfor?"+method+"=checkName",
			type:"post",
			data:$frm,
			dataTyep:"text",
			success:function(data){
				alert(data) ;
			}
		});
	});
});

//验证用户名
function nameFocus() {
	if ($("#username").val() == "") {
		$("#username").next(".errors").css({
			"display" : "inline-block",
			"color" : "#333"
			
		});
		$("#username").next(".errors").html("昵称长度应在4到16个字符之间");
		$("#username").css({"border": "2px solid #ffa07a"});
		return false ;
	}

}

function nameBlur() {
	$("#username").css("border", "2px solid red");
	$("#username").next(".errors").css({
		"display" : "inline-block",
		"color" : "red",
	});
	if ($("#username").val() == "") {
		
		$("#username").next(".errors").html("昵称不能为空");
		return false;
	} else if (!($("#username").val().length >= 4 && $("#username").val().length <= 16)) {
		
		$("#username").next(".errors").html("昵称长度应在4到16个字符之间");
		return false;
	} else {
		$("#username").css("border", "2px solid green");
		$("#username").next(".errors").hide();
		return true;
	}
}
//验证密码
function passFocus(){
	if($("#userpass").val()==""){
		$("#userpass").next(".errors").css({"display":"inline-block","color":"#333"});
		$("#userpass").next(".errors").html("密码应在6到32个字符之间") ;
		$("#userpass").css("border","2px solid #ffa07a");
		return false ;
	}
}

function passBlur(){
	var checkPass = /^[\d]+$/g ;
	$("#userpass").css("border","2px solid red");
	if($("#userpass").val()==""){
		$("#userpass").next(".errors").css({"display":"inline-block","color":"red"});
		$("#userpass").next(".errors").html("密码不能为空") ;
		return false ;
	}else if(!($("#userpass").val().length >= 6 && $("#userpass").val().length <= 32)){
		$("#userpass").next(".errors").css({"display":"inline-block","color":"red"});
		$("#userpass").next(".errors").html("密码长度应在6到32个字符之间") ;
		return false ;
	}else if(checkPass.test($("#userpass").val())){
		$("#userpass").next(".errors").css({"display":"inline-block","color":"red"});
		$("#userpass").next(".errors").html("密码不能全为纯数字") ;
		return false ;
	}else{
		$("#userpass").css("border","2px solid green");
		$("#userpass").next(".errors").hide();
		return true ;
	}
}
//确认密码
function checkPassFocus(){
	if($("#userpasscheck").val()==""){
		$("#userpasscheck").next(".errors").css({"display":"inline-block","color":"#333"});
		$("#userpasscheck").next(".errors").html("请再次输入密码进行密码确认") ;
		$("#userpasscheck").css("border","2px solid #ffa07a");
	
	}
}

function checkPassBlur(){
	
	if($("#userpasscheck").val()==""){
		$("#userpasscheck").css("border","2px solid red");
		$("#userpasscheck").next(".errors").css({"display":"inline-block","color":"red"});
		$("#userpasscheck").next(".errors").html("确认密码不能为空") ;
		return false ;
	}else if(!($("#userpasscheck").val() == $("#userpass").val())){
		$("#userpasscheck").next(".errors").css({"display":"inline-block","color":"red"});
		$("#userpasscheck").next(".errors").html("两次密码不一致") ;
		return false ;
	}else{
		$("#userpasscheck").css("border","2px solid green");
		$("#userpasscheck").next(".errors").hide();
		return true ;
	}
}
//邮箱
function checkEmailFocus(){
	if($("#email").val()==""){
		$("#email").next(".errors").css({"display":"inline-block","color":"#333"});
		$("#email").next(".errors").html("请输入邮箱账号") ;
		$("#email").css("border","2px solid #ffa07a");
	
	}
}

function checkEmailBlur(){
	var checkEmail = /^([\w\.\-])+\@(([\w\-])+\.)+([\w]{2,4})+$/ ;
	$("#email").css("border","2px solid red");
	if($("#email").val()==""){
		$("#email").next(".errors").css({"display":"inline-block","color":"red"});
		$("#email").next(".errors").html("邮箱不能空") ;
		return false ;
	}else if(!(checkEmail.test($("#email").val()))){
		$("#email").next(".errors").css({"display":"inline-block","color":"red"});
		$("#email").next(".errors").html("请输入正确的邮箱格式") ;
		return false ;
	}else {
		$("#email").css("border","2px solid green");
		$("#email").next(".errors").hide();
		return true ;
	}
}

//验证整个表单的控件
function checkForm() {
	if (passBlur()==false && nameBlur() == false && checkEmailBlur()==false && checkPassBlur()==false) {
		return false;
	}
	return true;

}
















