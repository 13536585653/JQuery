function yz(){
	var pattern =/^(?:[\u4e00-\u9fa5|a-zA-Z])+?$/; 
	var reg=/^[0-9]{1}([0-9]|[.])*$/;
	if($("#c1").val()=="" || !pattern.test($("#c1").val())){
		alert("输入框不能空、只能是中文是英文");
		return false;
	}else if($("#c3").val()=="" || !reg.test($("#c3").val())){
		alert("价格不能为空、只能是数字/小数点也不能在第一位我");
		return false;
		}
	else if($("#c4").val()==""){
		alert("描述不能为空");
		return false;
		}
}

function yzinput(){
	var pattern =/^(?:[\u4e00-\u9fa5|a-zA-Z])+?$/; 
	if($("#c1").val()=="" || !pattern.test($("#c1").val())){
		alert("输入框不能空、只能是中文是英文");
		return false;
	}
}


function user(){
	var pattern =/^[a-zA-Z]\w{3,15}$/ig;
	var email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
	var phone =/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
	if($("#Name").val()=="" || !pattern.test($("#Name").val())){
		alert("用户名不能空、只能是中文是英文");
		return false;
	}
	if($("#tel").val()=="" || !phone.test($("#tel").val())){
		alert("电话号码簿不正确，请重新输入！");
		return false;
	}
	if($("#email").val()=="" || !email.test($("#email").val())){
		alert("邮箱地址输入错误，请重新输入");
		return false;
	}
	if($.trim($("#addr").val()).length<0){
		alert("地址栏不能为空！");
		return false;
	}
}

function admin(){
	var pattern =/^[a-zA-Z]\w{3,15}$/ig;
	var email=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
	if($("#Name").val()=="" || !pattern.test($("#Name").val())){
		alert("用户名不能空、只能是中文是英文");
		return false;
	}
	if($("#email").val()=="" || !email.test($("#email").val())){
		alert("邮箱地址输入错误，请重新输入");
		return false;
	}
}

function yz2(){
	var pattern = /^(\w){6,20}$/;
	if($("#xinmima").val()!=$("#qrmima").val()){
		alert("两次输入不一致！");
		return false;
	}
	if($("#xinmima").val()=="" || !pattern.test($("#xinmima").val())){
		alert("只能输入6-20个字母、数字、下划线");
		return false;
	}
	if($("#qrmima").val()=="" || !pattern.test($("#qrmima").val())){
		alert("只能输入6-20个字母、数字、下划线");
		return false;
	}
}