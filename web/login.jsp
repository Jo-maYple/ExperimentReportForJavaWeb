<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>
</head>
<body>
<form action="loginServlet" method="post">
    用户名:<input type="text" placeholder="用户名" name="userName" required><br>
    密码:<input type="text" placeholder="密码" name="passwd" required><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
