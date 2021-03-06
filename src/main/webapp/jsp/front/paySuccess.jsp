<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/30
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>已购买的商品</title>
    <link href="/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
<hr/>
<table style="margin: 0 auto">
    <tr>
        <th>商品名</th>
        <th>商品价格</th>
        <th>商品数量</th>
    </tr>
    <c:forEach items="${successDetail}" var="detail">
        <tr>
            <td>${detail.pname}</td>
            <td>${detail.price}</td>
            <td>${detail.number}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
