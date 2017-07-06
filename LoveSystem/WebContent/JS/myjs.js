//提交按钮的验证
function check(){
			var regName=/^[\u2E80-\u9FFF]+$/;
			var lname=$("input[name='lname']").val();
			var ltime=$("input[name='ltime']").val();
			var lmoney=$("input[name='lmoney']").val();
			if(lname!==""&&ltime!=""&&lmoney!=""){
				if(!regName.test(lname)){
					alert("用户名输入有误！");
					return false;
				}
				if(!(lmoney>0)){
					alert("金额输入有误！");
					return false;
				}
				if("${msg}"!=""){
					alert("捐款已经成功，谢谢你的支持，祝你幸福安康！");
				}
				return true;
			}else{
				alert("表单不能为空！");
				return false;
			}
		}
		