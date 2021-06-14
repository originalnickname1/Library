<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="controller" method="post"/>
<input type="hidden" name="command" value="admin/editUser"/>
Id : ${user.getId()}</br>
Login : ${user.getLogin()}</br>
First Name : ${user.getFirstName()}</br>
Last Name : ${user.getLastName()}</br>
Blocked : ${user.getBlocked()}</br>
Role : ${user.getRoleId()}</br>
</body>
</html>
