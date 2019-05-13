<%--
  Created by IntelliJ IDEA.
  User: keyon
  Date: 2019/4/19
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页面</title>
    <script type="text/javascript" src="${basePath}/js/common/jquery-1.8.3.js"></script>
</head>
<body>
     <form id="form">
         请输入信息：<input type="text" name="information">
         <button value="点击提交" id="btn"></button>
     </form>

<script type="text/javascript">
    $("#btn").click(function () {
        $("#form").attr("action","${basePath}/test");
        $("#form").attr("method","post");
        $("#form").submit();
    })
</script>
</body>
</html>
