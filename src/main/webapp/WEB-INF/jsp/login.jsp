<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <div>
        <label for="name">账号：</label>
        <input type="text" name="name" id="name"/>
    </div>
    <div>
        <label for="password">密码：</label>
        <input type="password" name="password" id="password" />
    </div>
    <div>
        <input type="submit"/>
    </div>
</form>
</body>
</html>
