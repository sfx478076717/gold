<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/5
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>麦当劳</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.10.js"></script>
    <script type="text/javascript">
        $(function () {
           $("button").eq(0).click(function () {
               location.href="/show";
           });
            $("button").eq(1).click(function () {
                location.href="/jsp/front/register.jsp";
            });
            $("button").eq(2).click(function () {
                location.href="/jsp/front/showBalance.jsp";
            });
            $("button").eq(3).click(function () {
                location.href="";
            });
        });
    </script>
</head>
<body>
<!-- 头部导航栏 -->
<div id="header">
    <!-- Logo -->
    <div id="u40">
        <img id="u40_img"src="/images/logo.png"/>
        <div id="u40_text" >
            <p><span>logo</span></p>
        </div>
    </div>
    <!-- 店名 -->
    <div id="u41">
        <div id="u41_div"></div>
        <div id="u41_text">
            <p><span>麦当劳(店名)</span></p>
        </div>
    </div>
    <!-- 索引菜单栏 -->
    <div id="index">
        <button>返回首页</button>
        <button>注册/充值</button>
        <button>查询余额</button>
        <button>后台管理</button>
    </div>
</div>
</body>
</html>

