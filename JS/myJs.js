/**
 * Created by 123 on 2016/7/14.
 */
//表单校验
function check() {
    if ($("#name,#age,#address").val() == "") {
        alert("姓名、年龄和地址都不能为空！");
        return false;
    }

    if ($("#name").val() == "") {
        alert("请填写姓名！");
        return false;
    }
    if ($("#age").val() == "") {
        alert("请填写年龄！");
        return false;
    }
    if ($("#address").val() == "") {
        alert("请填写地址！");
        return false;
    }
        return true;
}
//获取文本框对象，封装成对象
function getBean() {
        //创建对象（javascript中的方式）
        //var bean=new Object();
        var bean={};
        bean.name=$("#name").val();
        bean.age=$("#age").val();
        bean.address=$("#address").val();
        return bean;
}

//将数据追加到表格
function appendtr(bean) {
        /*$("table").append(
            "<tr>"+
            "<td><input type='checkbox'></td>"+ "<td>"+bean.name+"</td>"+ "<td>"+bean.age+"</td>"+ "<td>"+bean.address+"</td>"
            +"</tr>");*/
        $("table").append(
            "<tr>" +
            "<td><input type='checkbox'/></td>"+
            "<td>"+bean.name+"</td>" +
            "<td>"+bean.age+"</td>" +
            "<td>"+bean.address+"</td>" +
            "</tr>");
}

//清空文本框
function cleanText() {
    $("#name").val("");
    $("#age").val("");
    $("#address").val("");
}

//隔行变色
function changeColor() {
    $("tr:odd").css("background-color","gray");
}

//删除数据
function removeDate() {
    if($(":checked").size()==0){
        alert("请选择删除项!");
        return false;
    }else{
        /*执行删除操作，由于当前元素是checkbox，而我们必须要删除行
        因此需要找到当前checkbox的父级元素。调用第一次parent()方法
        找到的是td元素，再一次调用parent()方法者找到当前行。然后将此tr直接remove掉*/
        $(":checkbox:checked").parent().parent().remove();
    }
}

