<%--
  Created by IntelliJ IDEA.
  User: 张志琳
  Date: 2022/3/23
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试@RequestMapping注解</title>
</head>
<body>
    <form action="/user/getParam">
        用户名：<input type="text" name="username">
        密码：<input type="password" name="password">
        提交：<input type="submit">
    </form>

</body>
</html>
