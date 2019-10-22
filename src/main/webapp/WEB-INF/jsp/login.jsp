<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-09-27
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shiro登陆</title>
</head>
<body>
欢迎来到shiro登陆页面
<form action="/login/doLogin" method="post">
    账号：<input type="text" name="name" value="">
    密码：<input type="password" name="password" value="">
    <input type="submit" value="确认">
</form>
</body>
</html>
