<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser!=null}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?editProfile"/>
        Id : ${sessionScope.loggedUser.id} <input type="hidden" name="id" value="${sessionScope.loggedUser.id}"><br/>
        <fmt:message key="all_users_jsp.login"/> : ${sessionScope.loggedUser.login} ~~~ New Login : <input name="login" value="${sessionScope.loggedUser.login}"/><br/>
        <fmt:message key="all_users_jsp.password"/> : ${sessionScope.loggedUser.password} ~~~ New Password : <input name="password" value="${sessionScope.loggedUser.password}"/><br/>
        <fmt:message key="all_users_jsp.first_name"/> : ${sessionScope.loggedUser.firstName} ~~~ New First Name : <input name="firstName" value="${sessionScope.loggedUser.firstName}"/><br/>
        <fmt:message key="all_users_jsp.last_name"/> : ${sessionScope.loggedUser.lastName} ~~~ New Last Name : <input name="lastName" value="${sessionScope.loggedUser.lastName}"/><br/>
        <fmt:message key="all_users_jsp.blocked"/> : ${getUserInfoBlocked} <input type="hidden" name="blocked" value="${sessionScope.loggedUser.blocked}" /><br/>
        <fmt:message key="all_users_jsp.role"/> : ${getUserInfoRole} <input type="hidden" name="roleId" value="${sessionScope.loggedUser.roleId}" /><br/>
    </form>
        <c:if test="${sessionScope.loggedUser.roleId==3}">
            <fmt:message key="all_users_jsp.fine"/> : ${getUserInfoFine}
        <form action="controller" method="post">
            <input type="hidden" name="command" value="user?payFine"/>
            <input value="<fmt:message key="all_users_jsp.pay_fine"/>" type="submit">
        </form>
        </c:if>
        <input value="<fmt:message key="all_users_jsp.edit_profile"/>" type="submit"/></br>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?deleteProfile"/>
        <input value="<fmt:message key="all_users_jsp.delete_profile"/>" type="submit">
    </form>
</c:if>