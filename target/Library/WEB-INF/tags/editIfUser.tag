<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${user.roleId==3}">
    Id : ${getUserInfo.id} <input type="hidden" name="id" value="${getUserInfo.id}"><br/>
    Login : ${getUserInfo.login} ~~~ New Login : <input name="login" value="${getUserInfo.login}"/><br/>
    Password : ${getUserInfo.password} ~~~ New Password : <input name="password" value="${getUserInfo.password}"/><br/>
    First Name : ${getUserInfo.firstName} ~~~ New First Name : <input name="firstName" value="${getUserInfo.firstName}"/><br/>
    Last Name : ${getUserInfo.lastName} ~~~ New Last Name : <input name="lastName" value="${getUserInfo.lastName}"/><br/>
    Blocked : ${getUserInfoBlocked} <input type="hidden" name="blocked" value="${getUserInfo.blocked}"><br/>
    Role : ${getUserInfoRole} <input type="hidden" name="roleId" value="${getUserInfo.roleId}"><br/>
    <input value="Edit User" type="submit"/></br>
    </form>
</c:if>