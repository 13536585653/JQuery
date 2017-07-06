// JavaScript Document
//整个表单的切换等...
	$(document).ready(function() {

		$(".form").slideDown(300);

		$("#landing").addClass("border-btn");

		$("#registered").click(function() {
			$("#landing").removeClass("border-btn");
			$("#landing-content").hide(300);
			$(this).addClass("border-btn");
			$("#registered-content").show(300);

		});

		$("#landing").click(function() {
			$("#registered").removeClass("border-btn");
			$(this).addClass("border-btn");

			$("#landing-content").show(300);
			$("#registered-content").hide(300);
		})
	});
	
	//验证码
	var changeYzm=function(){
		  document.getElementById
		  ("yzm").src="yzm.jsp?date="+new Date();
	  }

//用户名验证
function nameInput1(){		//聚焦昵称输入框
    var nameInput=document.getElementById("nameInput");
    document.getElementById("nameDiv").innerHTML="请输入用户名";
    document.getElementById("nameDiv").style.color="#808080";
    nameInput.setAttribute("style","border-topColor:#A7B6C4;background-color:#fff");
}
function nameInput2(){		//失焦昵称输入框
    var reg=/^[a-z0-9_-]{3,16}$/;
    var nameInput=document.getElementById("nameInput");
    var nameDiv=document.getElementById("nameDiv");
    nameInput.setAttribute("style","background-color:#F3F9FC");
    if(nameInput.value==""){
        nameDiv.style.color="#f00";
        nameDiv.innerHTML="！用户名不能为空";
    }else{
        if(!reg.test($("#nameInput").val())){
            nameDiv.style.color="#f00";
            nameDiv.innerHTML="！用户名输入错误";
            alert("用户名由3-16位a`A和数字组成！");
        }else{
            nameDiv.innerHTML="√";
        }

    }
}

//密码验证
function pwdInput1(){		//聚焦密码输入框
    var pwdInput=document.getElementById("pwdInput");
    document.getElementById("pwdDiv").innerHTML="请输入密码";
    document.getElementById("pwdDiv").style.color="#808080";
    pwdInput.setAttribute("style","border-topColor:#A7B6C4;background-color:#fff");
}
function pwdInput2(){		//失焦密码输入框
    var reg=/^[a-z0-9_-]{6,18}$/;
    var pwdInput=document.getElementById("pwdInput");
    var pwdDiv=document.getElementById("pwdDiv");
    var nameInputVal=document.getElementById("nameInput").value;
    pwdInput.setAttribute("style","background-color:#F3F9FC");
    if(nameInputVal!=""){
        if(pwdInput.value==""){
            pwdDiv.style.color="#f00";
            pwdDiv.innerHTML="！密码不能为空";
        }
        if(!reg.test($("#pwdInput").val())){
                pwdDiv.style.color="#f00";
                pwdDiv.innerHTML="！密码不符合规则";
                alert("密码为3-16位a`A和数字组成！");
        }else {
                pwdDiv.innerHTML="√";
        }
    }else{
        pwdDiv.style.color="#f00";
        pwdDiv.innerHTML="！请先输入用户名";
    }
}

//再次密码验证
function pwdInputs1(){		//聚焦昵称输入框
    var pwdInputs=document.getElementById("pwdInputs");
    document.getElementById("pwdDivs").innerHTML="请再次输入密码";
    document.getElementById("pwdDivs").style.color="#808080";
    pwdInputs.setAttribute("style","border-topColor:#A7B6C4;background-color:#fff");
}
function pwdInputs2(){		//失焦昵称输入框
    var pwdInputs=document.getElementById("pwdInputs");
    var pwdDiv=document.getElementById("pwdInput");
    var pwdDivs=document.getElementById("pwdDivs");
    var pwdInputVal=document.getElementById("pwdInput").value;
    pwdInputs.setAttribute("style","background-color:#F3F9FC");
    if(pwdInputVal!=""){
        if(pwdInputs.value==""){
            pwdDivs.style.color="#f00";
            pwdDivs.innerHTML="！密码不能为空";
        }else{
            if($("#pwdDiv").text()=="√"){
                if(pwdInputVal==pwdInputs.value){
                pwdDivs.innerHTML="√";
                }else{
                pwdDivs.style.color="#f00";
                pwdDivs.innerHTML="！密码输入不一致";
                }
            }else {
                pwdDivs.style.color="#f00";
                pwdDivs.innerHTML="！密码不符合规则"
            }

        }
    }else{
        pwdDivs.style.color="#f00";
        pwdDivs.innerHTML="！请按顺序输入";
    }
}

//性别验证
$(function () {
    $("#sexInput").focus(function () {
        $("#sexDiv").text("请输入性别").css({color:"#808080"});
        $("#sexInput").css("background","#fff");
    });

    $("#sexInput").blur(function () {
         if($("#sexInput").val()==""){
            $("#sexDiv").text("！性别不能为空").css({color:"red"});
            $("#sexInput").css("background","#F3F9FC");
            }else{
                if($("#sexInput").val()=="男"||$("#sexInput").val()=="女"){
                    $("#sexDiv").text("√");
                }else{
                    $("#sexDiv").text("！你的填写有误").css({color:"red"});
                    alert("只能填写男或女！");
                }
            }
        });

    });

//地址验证
$(function () {
    $("#addressInput").focus(function () {
        $("#addressDiv").text("请输入地址").css({color:"#808080"});
        $("#addressInput").css("background","#fff");
    });

    $("#addressInput").blur(function () {
        if($("#addressInput").val()==""){
            $("#addressDiv").text("！地址不能为空").css({color:"red"});
            $("#addressInput").css("background","#F3F9FC");
        }else{
            if($("#addressInput").val().length<4){
                alert("你输入的是非法地址！");
            }else{
                $("#addressDiv").text("√");
            }
        }
    });

});

//Email验证
$(function () {
    $("#emailInput").focus(function () {
        $("#emailDiv").text("请输入你的邮箱").css({color:"#808080"});
        $("#emailInput").css("background","#fff");
    });

    $("#emailInput").blur(function () {
        var reg=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if($("#emailInput").val()==""){
            $("#emailDiv").text("！邮箱不能为空").css({color:"red"});
            $("#emailInput").css("background","#F3F9FC");
        }else{
            if(!reg.test($("#emailInput").val())){
                alert("你输入的邮箱不符合规则！  邮箱格式为xxx@xxxxx.xxx");
            }else {
                $("#emailDiv").text("√");
            }
        }
    });

});

//手机号码验证
$(function () {
    $("#phoneInput").focus(function () {
        $("#phoneDiv").text("请输入你的号码").css({color:"#808080"});
        $("#phoneInput").css("background","#fff");
    });

    $("#phoneInput").blur(function () {
        if($("#phoneInput").val()==""){
            $("#phoneDiv").text("！手机号不能为空").css({color:"red"});
            $("#phoneInput").css("background","#F3F9FC");
        }else{
            /*var phone = document.getElementById('phoneInput').value;*/
            if(!(/^1[3|4|5|7|8]\d{9}$/.test($("#phoneInput").val()))) {
                $("#phoneDiv").text("！手机号不符合规则").css({color:"red"});
                return false;
            }else{
                $("#phoneDiv").text("√");
            }
        }
    });

});


//立即注册按钮
$(function(){
	$("#registeredtxt").click(function () {
        $(".form").slideDown(300);
        $("#landing-content").hide(300);
        $("#registered-content").show(300);
        $("#landing").removeClass("border-btn");
        $("#registered").addClass("border-btn");
    });

});

//清空表单的方法。
function emptyData() {
    $("#nameInput").val("");
    $("#pwdInput").val("");
    $("#pwdInputs").val("");
    $("#addressInput").val("");
    $("#sexInput").val("");
    $("#emailInput").val("");
    $("#phoneInput").val("");
    $("#captchaInput").val("");
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
   



