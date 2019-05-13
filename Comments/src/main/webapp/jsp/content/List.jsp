<%--
  Created by IntelliJ IDEA.
  User: keyon
  Date: 2019/4/19
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>广告列表</title>
    <script type="text/javascript"  src="${basePath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript"  src="${basePath}/js/list.js"></script>
</head>
<body>
<form id="myForm">
    <input type="hidden" id="basePath" value="${basePath}">
    <input type="hidden" id="adId" name="id">
    <input type="hidden"  name="currentPage" value="2">
    <input type="hidden"  name="currentPage" value="2">
    <table border="1">
        <tr>
            <td>
             <input type="text" name="title" value="">
                <input type="button" value="查询" id="searchBtn">
            </td>
            <td><input type="button" value="批量删除" id="deleteBatchBtn"></td>
        </tr>
        <tr>
            <td><input type="radio"></td>
            <td>序号</td>
            <td>广告名称</td>
            <td>链接地址</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${customList}" var="list" varStatus="st">
            <tr>
                <td><input type="checkbox" name="id"></td>
                <td>${list.count}</td>
                <td>${list.title}</td>
                <td>${list.link}</td>
                <td><a href="javascript:deleteAd(${list.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table>

</form>

</body>
</html>
