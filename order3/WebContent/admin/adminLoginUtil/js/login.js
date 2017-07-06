// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				var admin = $("#admin").val();
				var pwd = $("#password").val();
				var yzm = $("#j_captcha").val();		
				if(admin == ''){
					show_err_msg('用户名还没填呢！');	
					admin.focus();
				}else if(pwd == ''){
					show_err_msg('密码还没填呢！');
					pwd.focus();
				}else if(yzm == ''){
					show_err_msg('验证还没填呢！');
					pwd.focus();
				}else{
					$.post("adminServlet",{"admin":admin,"pwd":pwd,"yzm":yzm},function(result){
						if(result!=null){
							if(result==0){
								show_err_msg("用户名或密码不正确");
								return false;
							}
							else if(result==1){
								show_err_msg("验证码不正确！");
								return false;
							}
							else{
								 show_msg('登录成功！ 正在为您跳转...','admin/adminIndex/administer-index.jsp?name='+result);
								 
								//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
							 }
						 }
								
					});
					
				}
			});
		});