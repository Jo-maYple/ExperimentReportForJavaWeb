<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
    <form action="addServlet" method="post">
        姓名:<input type="text" placeholder="姓名" name="userName" required><br>
        学号:<input type="text" placeholder="学号" name="number" required><br>
        性别:<select name="sex" id="" required>
                <option value="男">男</option>
                <option value="女">女</option>
             </select><br>
        班级:<input type="text" placeholder="班级" name="className" required><br>
        所属院系:<input type="text" placeholder="所属院系" name="department" required><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
