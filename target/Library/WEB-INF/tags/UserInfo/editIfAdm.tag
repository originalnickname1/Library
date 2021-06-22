<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId == 1}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="admin?editUser"/>
        Id : ${getUserInfo.id} <input type="hidden" name="id" value="${getUserInfo.id}"><br/>
        <fmt:message key="all_users_jsp.login"/> : ${getUserInfo.login} New Login : <input name="login" value="${getUserInfo.login}"/><br/>
        <fmt:message key="all_users_jsp.password"/>  : ${getUserInfo.password} ~~~ New Password : <input name="password" value="${getUserInfo.password}"/><br/>
        <fmt:message key="all_users_jsp.first_name"/>  : ${getUserInfo.firstName} ~~~ New First Name : <input name="firstName" value="${getUserInfo.firstName}"/><br/>
        <fmt:message key="all_users_jsp.last_name"/>  : ${getUserInfo.lastName} ~~~ New Last Name : <input name="lastName" value="${getUserInfo.lastName}"/><br/>
        <fmt:message key="all_users_jsp.blocked"/>  : ${getUserInfoBlocked} ~~~ New Blocked : <select name = "blocked">
        <option value=0>UNBLOCKED</option>
        <option value=1>BLOCKED</option>
    </select><br/>
        <fmt:message key="all_users_jsp.role"/> : ${getUserInfoRole} ~~~ New Role :  <select name = "roleId">
        <option value=3>USER</option>
        <option value=2>LIBRARIAN</option>
    </select><br/>
        <input value="<fmt:message key="editIfAdm.tag.edit"/>" type="submit"/></br>
    </form>
    <a href="controller?command=admin%3FdeleteUser&userId=${getUserInfo.id}"><input value="<fmt:message key="editIfAdm.tag.delete"/>" type="submit"></a><br/>
</c:if>
