<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirm</title>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script  src="../js/bootstrap.min.js"></script>
    <script src="../js/confir-form.js"></script>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/confir-form.css">
</head>
<body>
<div class="container-fluid" id="login" style="position: relative;margin-top: 0px;" >
    <p class="row">
    <div class="pull-right right"  >
        <a href="#" >登录</a>
        &nbsp;&nbsp;
        <a href="#" >注册</a>
    </div>
    <div class="pull-right right">
        <a href="myform.jsp">我的订单</a>&nbsp;&nbsp;&nbsp;
        <a href="shopping.jsp">我的购物车</a>&nbsp;&nbsp;&nbsp;
        <a href="../bangz.html">常见的问题</a>
    </div>
    <div class="col-lg-3" id="colx">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="输入搜索的商品">
                     <span class="input-group-btn">
                    <button  class="btn btn-default" type="button" style="color: #aaaaaa">搜索</button>
                    </span>
        </div><!-- /input-group -->
    </div>
    <div class="pull-right right"></div>
    </p>
</div>
<div class="container-fluid" style="width: 1000px;">
    <div class="pull-left" style="margin-left: -10px;">
        <a href="../index.html"> <img src="../img/myding.gif"></a>
    </div>
</div>
<div class="container-fluid" style="width: 1000px;">
    <div class="msg2" >
        <span class="bb-right"><a href="../index.html" style="color: #666">首页</a></span>
       <p> <b>确认收货地址 </b>
        <input type="button" class="btn btn-default" id="btn-update" value="修改收货地址"></p>
    </div>
    <p style="margin-left: 30px;"><strong><span>收货地址:</span></strong><span>sdfsd</span></p>
 </div>
    <center>
        <form>
    <div id="in">
        <div class="msg"><b>确认订单信息</b></div>
        <table width="1000px">
            <tr id="dp">
                <td width="25%">店铺属性</td>
                <td width="20%">商品属性</td>
                <td width="10%">单价(元)</td>
                <td width="10%">数量</td>
                <td width="20%">优惠方式(元)</td>
                <td width="15%">小计(元)</td>
            </tr>
</table>
<table width="1000px;">
            <tr style="height: 20px"></tr>
            <tr class="photo font" style="background-color: #fbfcff;text-align: center;border-top:1px dotted #b2d1f1 ">
                <td width="25%">
                    <div class="photo1">
                        <img src="../img/photo.png" style="cursor: pointer;margin-right: 17px">
                    </div>
                 <div class="left">
                    <a href="#" style="left: 20px">这个打卡机司法局第三</a>
                 </div>
                    <div class="left">时间：卖家承诺半小时之内送货</div>
                </td>
                <td><span></span></td>
                <td><span style="position: relative;">100￥</span></td>
                <td><span style="position: relative;">1</span></td>
                <td><span style="position: relative;">活动打折</span></td>
                <td ><span style="position: relative;">200</span></td>
            </tr>
</table>
<table   width="1000px" style="background-color: #f2f7ff;border-bottom: dotted 1px #b2d1f1;font-size: 13px;">
            <tr>
                <td width="47%" height="30px">
                    <div style="float: left;margin-top: 10px;margin-left: 10px">给卖家留言：<br><font class="ts">温馨提示</font></div>
                    <div  style="margin-left: 10px">
                        <input type="text" class="message" placeholder="选填(对本次交易的说明)，建议与卖家协商一致的内容">
                    </div></td>
                <td  width="54%">
                    <div style="float: left;margin-left: 25px">运送方式：值班人员 配送</div>
                    <div style="float: right;color: #ff6600;margin-right: 11%">0.00</div>
                </td>
            </tr>
            <tr>
               <td rowspan="4" style="height: 150px"></td>
            </tr>
            <tr>
                <td>
                    <div style="margin-left: 25px">发货时间：卖家承诺在买家付款后30分钟<a href="#">配送</a>
                    </div></td>
            </tr>
            <tr>
            <td>
                <span class="bb-right" style="color: black;">合计(含运费)￥
                <font style="color: #ff6600 ">32.90</font></span>
            </td>
             </tr>
</table>

<div id="sub">
            <div style="margin-top: 10px;">
                <div class="bb-right" style="color: #ff6600;font-size: 26px;">22.2</div>
                <l class="bb-right" style="color: gray;font-size: 26px">￥</l>
                <b class="bb-right" style="margin-top: 10px">实付款：</b>
            </div>
            <div style="margin-top: 60px;margin-bottom: 50px">
                <div id="address" class="bb-right">22222222222222222222222222222222222</div>
                <b class="bb-right">寄送至：</b>
            </div>

            <div style="background: red;margin-top: 100px">
                <div class="bb-right">name+number</div>
                <b class="bb-right">收货人：</b>
            </div>
   </div><!---sub-->
        <div style="margin-left: 600px;">
            <div class="bb-right">
                <input id="submit" class="btn btn-default" style="font-weight:700;color:#fff;width: 182px;height: 40px;background: #ff9a00;border: 0px;-webkit-border-radius: 0px;" type="submit" value="提交订单"></div>
            <div class="bb-right" style="margin-top: 10px;margin-right: 25px"><a href="shopping.html"><img src="../img/return.png">返回购物车</a></div>
        </div>
        <div style="margin-left: 580px;margin-top: 215px">
            <span>$若价格变动，请在提交订单后联系卖家改价，并查看已买到的宝贝</span>
        </div>
</div><!-- in-->
        </form>
    <div id="bottom"></div>
    </center>
<div class="row" style="border: solid 1px #dfdfdf;width: 101.5%;background-color: #fafafa">
    <div class="footer2" >
        <div class="footer-size">
            <h4 class="footer-h4">用户帮助</h4>
            <ul class="list-unstyled">
                <li><a href="../bangz.html">常见问题</a></li>
            </ul>
        </div>
    </div>
    <div class="footer2"  >
        <div class="footer-size">
            <h4 class="footer-h4">我的</h4>
            <ul class="list-unstyled">
                <li><a href="#">互动评论</a></li>
                <li><a href="#">会员积分</a></li>
                <li><a href="myuser.jsp">我的信息</a></li>
            </ul>
        </div>
    </div>
    <div class="footer2" >
        <div class="footer-size">
            <h4 class="footer-h4">游戏</h4>
            <ul class="list-unstyled">
                <li><a href="#">打地鼠</a></li>
            </ul>
        </div>
    </div>
    <div class="footer2" >
        <div class="footer-size">
            <h4 class="footer-h4">客服电话:4006-888-887</h4>
            <ul class="list-unstyled">
                <li><a href="#">周一到周五&nbsp;9:00-22:00</a></li>
                <li><a href="#">客服电话&nbsp;免费长途</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="site-info">
    <span class="copyright">©</span>2016&nbsp;nuomi.com            &nbsp;<a href="#" class="link" target="_blank">京ICP证030173号</a>
    &nbsp;京公网安备11010802014106号
    &nbsp;<a href="#">营业执照信息</a>
    <div style="width:300px;margin:0 auto; padding:20px 0;">
        <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11000002000001" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="../img/a.png" style="float:left;">
            <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">京公网安备 11000002000001号</p></a>
    </div>
</div>
<div id="leftsead">
    <ul class="list-unstyled">
        <li><a><img src="../img/ll01.png" width="131" height="49" class="hides"/><img src="../img/l01.png" width="47" height="49" class="shows"/></a></li>
        <li><a id="top_btn"><img src="../img/ll06.png" width="131" height="49" class="hides"/><img src="../img/l06.png" width="47" height="49" class="shows" /></a></li>
    </ul>
</div>

<div class="modal" id="mymodal2" style="margin-top: 15%;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改</h4>
            </div>
            <div class="modal-body" id="count">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-default" style="background-color: #ff6600;border: none;color: #f1f1f1">修改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    $(function () {
        $("#btn-update").on("click",function () {
            $("#count").empty();
            $("#mymodal2").modal("toggle");
            $("#count").append("修改收货：<input type='text' class='form-control' style='width: 50%'>");
        });
    });
</script>
</body>
</html>