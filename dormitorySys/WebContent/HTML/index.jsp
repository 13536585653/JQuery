<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宿舍登记管理</title>
<script type="text/javascript" src="../JS/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../JS/bootstrap.min.js"></script>
<script src="../JS/myjs.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../CSS/mycss.css">
<script>
$(function () {
	//显示数据
	$.get("../findDormitoryServlet",function(result){
		addTable(result);
	});
	//注册模态框显示
   $("#register").off("click").on("click",function(){
	   $("#mymoda2").modal("show");
   });
   $("#f1 :button").on("click",function(){
	   var params=$("#f1").serialize();
		$.post("../RegisterServlet",params,function(result){
			alert(result);
			$("#mymoda2").modal("hide");
			empty();
			window.location.reload(true);
		});
   });
   $("#button2").on("click",function(){
	   $("#mymoda2").modal("hide");
   });
});
	function empty(){
		$("input[name='dormitoryId']").val("");
		$("input[name='stuName']").val("");
		$("input[name='clsName']").val("");
		$("input[name='inDate']").val("");
	}
function addTable(result){
	$.each(result,function(index,obj){
		$("#table").append(//"<div>"+
				"<table style='float:left;margin-right:15px;margin-top:15px;margin-left:15px;' border='1'>"+
				"<tr>"+
				"<td>"+"宿舍编号："+"</td>"+
				"<td>"+obj.dormitoryId+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td>"+"姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名"+"</td>"+
				"<td>"+obj.stuName+"</td>"+
				"</tr>"+
				"<td>"+"性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别："+"</td>"+
				"<td>"+obj.stuSex+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td>"+"班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级："+"</td>"+
				"<td>"+obj.clsName+"</td>"+
				"</tr>"+
				"<td>"+"入住时间："+"</td>"+
				"<td>"+obj.inDate+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td>"+"床&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号："+"</td>"+
				"<td>"+obj.bedNo+"</td>"+
				"</tr>"+
				"</table>"
				//"</div>"
				);
	});
}

</script>
</head>
<body>
<center>
	<div><h1>宿舍管理系统</h1></div>
	<div class="top">
		<div style="width:70%;">
			<div class="right" id="register"><input type="button" value="新增"></div>&nbsp;&nbsp;&nbsp;
			<div id="table" style="widht:400px;height:500px;border:solid 1px red;margin-top:30px;overflow:auto;">	
			</div>
		</div>
	</div>
</center>

<!-- 登记模态框-->
<div class="modal fade" id="mymoda2">
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
                                <h3 style="margin-bottom:30px;font-size:30px">学生入住信息登记</h3>
                                <form id="f1">
                                    	宿舍编号：<input type="text" name="dormitoryId">
                                    	<p><p><p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="stuName">
                                    	<p><p><p>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<input type="radio" name="stuSex" value="男" checked>男&nbsp;&nbsp;
                                    	<input type="radio" name="stuSex" value="女">女
                                    	<p><p><p>班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：<input type="text" name="clsName">&nbsp;&nbsp;
                                    	<p><p><p>入住时间：<input type="date" name="inDate">
                                    	<p><p><p>床&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<select name="bedNo">
           						

															<option>1</option>
															           						
															
															<option>2</option>
															           						
															
															<option>3</option>
															           						
															
															<option>4</option>
															           						
															
															<option>5</option>
															           						
															
															<option>6</option>
           													</select>
           	
                                    	<p><p><p><input class="btn" id="button1" type="button" value="登记">
                                    	<input class="btn" type="button" id="button2" value="取消">
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
