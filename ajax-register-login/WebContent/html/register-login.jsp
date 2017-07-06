<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册登录</title>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-spinner.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script src="../js/myjs.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.spinner.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/mycss.css">
<script>
function empty(){
	$("input[name='uname']").val("");
	$("input[name='upassword']").val("");
	$("input[name='uage']").val("");
	$("input[name='unum']").val("");
	$("input[name='uaddress']").val("");
}
function empty1(){
	$("input[type='text']").val("");
	$("input[type='password']").val("");
}
$(function () {
	//注册模态框显示
   $("#register").off("click").on("click",function(){
	   $("#mymoda2").modal("show");
   });
   $("#f1 :button").on("click",function(){
	   var params=$("#f1").serialize();
		$.post("../registerServlet",params,function(result){
			alert(result);
			$("#mymoda2").modal("hide");
			empty();
		});
   });
   
   //登录模态框显示
   $("#login").off("click").on("click",function(){
	   $("#mymoda3").modal("show");
   });
   $("#f2 :button").on("click",function(){
	   var uName= $("input[type='text']").val();
	   var uPassword = $("input[type='password']").val();
	   var params=$("#f2").serialize();
	   $.get("../loginServlet",params,function(result){
		   if($.trim(result)=="登录失败！"){
			   alert("用户名或密码输入错误！");
			   empty1();
			   return false;
		   }else{
			   alert(result);
		   }
		   
		   if($.trim(result)=="登录成功！"){
			   location.href="index.jsp";
		   }
		   empty1();
	   });
   });
});

</script>
</head>
<body>
<center>
	<div class="top">
		<div>
			<div class="right" id="register">|&nbsp;&nbsp;注册</div>&nbsp;&nbsp;&nbsp;
			<div class="right" id="login">登录</div>
		</div>
	</div>
</center>

<!-- 注册模态框-->
<div class="modal fade" id="mymoda2"  >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="height: 20px;">
                <button type="button" style="margin-top: -10px;" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body" id="count">
                <div class="zhuce_body">
                    <div class="zhuce_kong">
                        <div class="zc">
                            <div class="bj_bai">
                                <h3 style="margin-bottom:30px;font-size:30px">欢迎注册</h3>
                                <form id="f1">
                                    	用户名：<input type="text" name="uname">
                                    	<p><p><p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="upassword">
                                    	<p><p><p>性&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="usex" value="男" checked>男&nbsp;&nbsp;
                                    	<input type="radio" name="usex" value="女">女
                                    	<p><p><p>年&nbsp;&nbsp;&nbsp;&nbsp;龄：<input type="text" name="uage">&nbsp;&nbsp;
                                    	<p><p><p>电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="unum">
                                    	<p><p><p>地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" name="uaddress">
                                    	<p><p><p><input class="btn" type="button" value="注册">
                                </form>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <div class="modal-footer" style="border-top:none;text-align: center">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--登录模态框-->
<div class="modal fade" id="mymoda3">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="height: 20px;">
                <button type="button" style="margin-top: -10px;" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body">
                <div class="zhuce_body" style="height:270px;">
                    <div class="zhuce_kong login_kuang">
                        <div class="zc">
                            <div class="bj_bai">
                                <h3>登录</h3>
                                <form id="f2">
                                    <p><p><p><p><p><p><input name="userName" type="text" class="kuang_txt" placeholder="手机号">
                                    <p><p><p><p><p><p><input name="userPwd" type="password" class="kuang_txt" placeholder="密码">
                                    <p><p><p><p><p><p><input type="button" class="btn_zhuce" value="登录" onclick="return subcheck();">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer" style="border-top:none;text-align: center">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>