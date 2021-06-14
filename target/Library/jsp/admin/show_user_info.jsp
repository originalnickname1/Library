<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Admin page to obtain all users</h2>
<form action="controller" method="post">
    <input type="hidden" name="command" value="admin?editUser"/>
    Id : ${getUserInfo.id} <input type="hidden" name="id" value="${getUserInfo.id}"><br/>
    Login : ${getUserInfo.login} ~~~ New Login : <input name="login" value="${getUserInfo.login}"/><br/>
    Password : ${getUserInfo.password} ~~~ New Password : <input name="password" value="${getUserInfo.password}"/><br/>
    First Name : ${getUserInfo.firstName} ~~~ New First Name : <input name="firstName" value="${getUserInfo.firstName}"/><br/>
    Last Name : ${getUserInfo.lastName} ~~~ New Last Name : <input name="lastName" value="${getUserInfo.lastName}"/><br/>
    Blocked : ${getUserInfoBlocked} ~~~ New Blocked : <select name = "blocked">
    <option value=0>UNBLOCKED</option>
    <option value=1>BLOCKED</option>
</select><br/>
    Role : ${getUserInfoRole} ~~~ New Role :  <select name = "roleId">
                                                      <option value=3>USER</option>
                                                      <option value=2>LIBRARIAN</option>
                                              </select><br/>
    <input value="Edit User" type="submit"/></br>
</form>
<a href="controller?command=admin%3FdeleteUser&userId=${getUserInfo.id}">Delete User</a><br/>

</body>
</html>
