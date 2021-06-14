<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Admin page to obtain all users</h2>
<form action="controller" method="post"/>
<input type="hidden" name="command" value="editUser"/>
Id : ${getUserInfo.id}</br>
Login : ${getUserInfo.login} ~~~ New Login : <input name="login"/></br>
Password : ${getUserInfo.password} ~~~ New Password : <input name="password" type="password"/><br/>
First Name : ${getUserInfo.firstName} ~~~ New First Name : <input name="firstName"/></br>
Last Name : ${getUserInfo.lastName} ~~~ New Last Name : <input name="lastName"/></br>
Blocked : ${getUserInfo.blocked} ~~~ New Blocked : <input name="blocked"/></br>
Role : ${getUserInfo.roleId} ~~~ New Role : <input name="roleId"/></br>
<a href="index.jsp">Back<a/>
</body>
</html>
