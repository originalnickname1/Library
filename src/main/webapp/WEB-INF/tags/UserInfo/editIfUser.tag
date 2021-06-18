<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser!=null}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?editProfile"/>
        Id : ${sessionScope.loggedUser.id} <input type="hidden" name="id" value="${sessionScope.loggedUser.id}"><br/>
        Login : ${sessionScope.loggedUser.login} ~~~ New Login : <input name="login" value="${sessionScope.loggedUser.login}"/><br/>
        Password : ${sessionScope.loggedUser.password} ~~~ New Password : <input name="password" value="${sessionScope.loggedUser.password}"/><br/>
        First Name : ${sessionScope.loggedUser.firstName} ~~~ New First Name : <input name="firstName" value="${sessionScope.loggedUser.firstName}"/><br/>
        Last Name : ${sessionScope.loggedUser.lastName} ~~~ New Last Name : <input name="lastName" value="${sessionScope.loggedUser.lastName}"/><br/>
        Blocked : ${getUserInfoBlocked} <input type="hidden" name="blocked" value="${sessionScope.loggedUser.blocked}" /><br/>
        Role : ${getUserInfoRole} <input type="hidden" name="roleId" value="${sessionScope.loggedUser.roleId}" /><br/>
    </form>
        <c:if test="${sessionScope.loggedUser.roleId==3}">
        Fine : ${getUserInfoFine}
        <form action="controller" method="post">
            <input type="hidden" name="command" value="user?payFine"/>
            <input value="Pay Fine" type="submit">
        </form>
        </c:if>
        <input value="Edit User" type="submit"/></br>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?deleteProfile"/>
        <input value="Delete Profile" type="submit">
    </form>
</c:if>