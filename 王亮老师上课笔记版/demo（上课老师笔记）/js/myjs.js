/**
 * Created by wangl on 2016/7/14.
 */
//表单校验
function check(){
    if($("#uname").val()==""){
        alert("请填写姓名");
        return false;
    }
    if($("#age").val()==""){
        alert("请填写年龄");
        return false;
    }
    if($("#addr").val()==""){
        alert("请填写地址");
        return false;
    }
    return true;
}
//获取文本框数据，封装成对象
function getBean(){
    var bean = new Object();
    bean.name = $("#uname").val();
    bean.age = $("#age").val();
    bean.addr = $("#addr").val();
    return bean;
}
//将数据追加到表格
function appendtr(bean){
    $("table").append(
        "<tr>" +
            "<td><input type='checkbox'/></td>"+
            "<td>"+bean.name+"</td>" +
            "<td>"+bean.age+"</td>" +
            "<td>"+bean.addr+"</td>" +
        "</tr>");
}
//清空文本框
function cleanText(){
    $("#uname").val("");
    $("#age").val("");
    $("#addr").val("");
}
//隔行变色
function changeColor(){
    $("tr:odd").css("background-color","#FF99CC");
}
//删除数据
function removeData(){
    if($(":checkbox:checked").size()==0){
        alert("请选择删除项");
        return;
    }else{
        /*执行删除操作,由于当前元素是checkbox，而我们必须要删除行
        因此需要找到当前checkbox的父级元素。调用第一次parent()方法
        找到的是td元素，再一次调用parent()方法则找到当前行。然后将此tr
        直接remove
        */
        $(":checkbox:checked").parent().parent().remove();
    }
}