<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <title>Hello World!</title>
</head>
<body>
<p1>欢迎来到hello 界面</p1>
<sec:authorize access="hasRole('ROLE_USER')">
    您是超级管理员,可看到该信息:(这里可以用逗号分隔，加入多个角色你拥有管理员权限)
</sec:authorize><br>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
</body>
</html>