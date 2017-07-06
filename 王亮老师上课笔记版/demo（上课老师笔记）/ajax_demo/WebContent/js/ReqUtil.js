/**
 * Created by wangl on 2016/7/19.
 */
//创建异步请求对象(XMLHttpRequest)
function createRequest(){
    var req = null;
    //判断当前浏览器是否支持XMLHttpRequest对象
    //因为早期的IE版本(IE5)并不支持XMLHttpRequest
    //而是以ActiveX控件的形式来支持
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return req;
}