/**
 * Created by 123 on 2016/7/16.
 */
function createXMLHttpReq() {
    var xmlhttp;
    if(window.XMLHttpRequest){//code for IE7+,Firefox,Chrome,Opera,Safari
        xmlhttp=new XMLHttpRequest();
    }else {
        //ActiveXObject客户端报表
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}