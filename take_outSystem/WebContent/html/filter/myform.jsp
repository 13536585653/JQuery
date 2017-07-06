<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyForm</title>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <link rel="stylesheet" href="../css/myform.css">
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/index.js"></script>
</head>
<body>
<div class="container-fluid" id="login" style="margin-top: -7%">
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
    <div class="pull-right right">欢迎,${User}</div>
    </p>
</div>
<div class="container-fluid" style="margin-top: 7% ;position: relative;width: 78%; border-bottom: solid 1px #ccc">
    <div class="pull-left ">
        <a href="../index.html"><img src="../img/myfrom2.gif" ></a>
    </div>
    <div id="login-left" style="margin-top: 7%">
        <a href="../index.html">首页</a>
    </div>
</div>
<div  class="container-fluid" style="width: 80%;margin-top: 1.5%">
    <div class="pull-left" id="myform">
        我的订单
    </div>
    <div class="pull-left" style="width: 80%;height:auto;-webkit-border-radius: 4px;">
        <table class="bought-table-mod__table___25sFG table-head-mod__table___3CnjL" >
            <colgroup>
            <col class="bought-table-mod__col1___2rjCp" >
            <col class="bought-table-mod__col2___1JsMe" >
            <col class="bought-table-mod__col3___2Ph44" >
            <col class="bought-table-mod__col4___2QGCO" >
            <col class="bought-table-mod__col5___3WbKm" >
            <col class="bought-table-mod__col6___1F5s8" >
            <col class="bought-table-mod__col7___2XGGB" >
        </colgroup>
            <tbody >
            <tr style="height: 50px;">
                <th class="center">宝贝</th>
                <th class="center">单价</th>
                <th class="center">数量</th>
                <th class="center">商品操作</th>
                <th class="center">实付款</th>
                <th>
                    <span class="field-select-mod__select___39vqz trade-select table-head-mod__status___2mXZ8 rc-select rc-select-enabled">
                        <span class="rc-select-selection rc-select-selection--single"  >
                            <span class="rc-select-selection__rendered">
                                <span >交易状态</span>
                            </span>
                        </span>
                    </span>
                </th>
                <th data-reactid=".0.4.1.0.6">交易操作</th>
            </tr>
            </tbody>
        </table>
        <div class="index-mod__order-container___1ur4-">
            <div  class="bought-wrapper-mod__trade-order___3jy1n bought-wrapper-mod__closed___2prfr" >
                <table class="bought-table-mod__table___25sFG bought-wrapper-mod__table___2OUpL">
                    <colgroup >
                        <col class="bought-table-mod__col1___2rjCp" >
                        <col class="bought-table-mod__col2___1JsMe" >
                        <col class="bought-table-mod__col3___2Ph44">
                        <col class="bought-table-mod__col4___2QGCO">
                        <col class="bought-table-mod__col5___3WbKm">
                        <col class="bought-table-mod__col6___1F5s8">
                        <col class="bought-table-mod__col7___2XGGB" >
                    </colgroup>
                    <tbody class="bought-wrapper-mod__head___1bMql" >
                    <tr >
                        <td class="bought-wrapper-mod__head-info-cell___1jJw2" >
                            <label class="bought-wrapper-mod__checkbox-label___31LqK" style="margin-top: 6px;">
                                <span class="bought-wrapper-mod__create-time___3gHYC">2016-07-27</span>
                            </label>
                            <span style="font-size: 13px;">
                                <span>订单号</span><span>:</span><span>2120142896011128</span>
                            </span>
                        </td>
                        <td colspan="4" class="bought-wrapper-mod__seller-container___3jdAE"></td>
                        <td></td><td></td><td></td><td></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td class="sol-mod__no-br___2nL95">
                        <div class="ml-mod__container___2C36y production-mod__production___2zW52 suborder-mod__production___3WebF">
                            <div class="ml-mod__media___29F2f" style="width:80px; height: 90px;">
                                <a class="production-mod__pic___2FLWo" href="#">
                                    <span></span>
                                    <img src="../img/0.jpg" width="80"height="80">
                                    <span> </span>
                                </a>
                            </div>
                            <div style="margin-left:90px;">
                            <p><a href="#" >
                                <span> </span>
                                    <span style="line-height:16px;">
                                     仅售66元，价值94元井岸店双人餐！品质层层把关，
                                     营养健康，口感醇厚，味道鲜美，每道菜都精心制作，
                                      令你回味无穷，唇齿留香！
                                    </span><span> </span>
                                </a></p>
                            </div>
                        </div>
                        </td>
                        <td class="sol-mod__no-br___2nL95">
                        <div class="price-mod__price___1ZG-e">
                            <p>
                            <span>￥</span>
                            <span>9.98</span>
                            </p>
                        </div>
                        </td>
                        <td class="sol-mod__no-br___2nL95">
                            <div id="pyce"><p>1</p></div>
                        </td>
                        <td>
                            <div><p style="margin-bottom:3px;">
                                <span class="text-mod__link___36nmM text-mod__hover___t2aVK" >
                                    <a href="#">删除订单</a>
                                </span>
                            </p></div>
                        </td>
                        <td>
                            <div>
                                <div class="price-mod__price___1ZG-e">
                                    <p><strong>
                                      <span>￥</span>
                                      <span>9.98</span>
                                    </strong></p>
                                </div>
                                <p style="color:#6c6c6c;font-family:verdana;">
                                    <span></span>
                                    <span>(原价￥100)</span>
                                    <span></span><span></span>
                                </p>
                                <p  class="pp">
                                    <a href="#" title="精选菜单" style="margin-right:5px;color: #fff" >精选</a>
                                </p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <p style="margin-bottom:3px;">
                                     <span class="text-mod__link___36nmM">交易成功</span>
                                </p>
                            </div>
                        </td>
                        <td class="sol-mod__no-br___2nL95">
                            <div><p style="margin-bottom:3px;">
                              <span class="text-mod__link___36nmM text-mod__hover___t2aVK">再次购买</span>
                            </p></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div><!-- index-mod__order-container___1ur4-结尾-->
    </div><!-- pullleft结尾-->
</div>
    <div id="phone" >
        <p class="phone-num">4006-888-887</p>
        <p class="phone-tips">客服电话 免长途费<br>周一至周日 9:00-22:00</p>
        <span class="sprite-line"></span>
    </div>
<div class="row" style="border: solid 1px #dfdfdf;width: 101.5%;margin-top: 10%;background-color: #fafafa">
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
</body>
</html>