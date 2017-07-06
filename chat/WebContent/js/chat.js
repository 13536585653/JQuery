/**
 * Created by 123 on 2016-08-03.
 */
//创建一个ajax请求
function createRequest() {
    var req=null;
    if(window.XMLHttpRequest){
        req=new XMLHttpRequest();
    }else{
        req=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return req;
}




function check(){
	$("#body").slideToggle();
    $("#chat").hide();
}
$(function () {
    $("#close").click(function () {
        $("#body").fadeToggle();
    });
    $("#close").mouseover(function () {
        $(this).css("background","#0e90d2");
    });
    $("#close").mouseout(function () {
        $(this).css("background","white");
    });
    $("#message").focus(function () {
        $("#x").show();
    });
    $("#message").blur(function () {
        if($("#message").val()==""){
            $("#x").hide();
        }
    });
    $("#x").click(function (){
        $("#message").val("");
    });
    //清空输入框
    $(":button").click(function(){
    var message=$("#message").val();
    $("#message").val("");
    });
});