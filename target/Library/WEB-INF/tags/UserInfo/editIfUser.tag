<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser!=null}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?editProfile"/>
        <div>
            <style>
                table,th,td{
                    border: 1px solid black;
                }
            </style>
            <table>
                <tr><td>Id : </td><td>${sessionScope.loggedUser.id} </td><td><input type="hidden" name="id" value="${sessionScope.loggedUser.id}"><br/>
                <tr><td><fmt:message key="all_users_jsp.login"/> :  </td><td>${sessionScope.loggedUser.login}  </td><td> New Login : <input name="login" value="${sessionScope.loggedUser.login}"/><br/>
                <tr><td><fmt:message key="all_users_jsp.password"/> :  </td><td>${sessionScope.loggedUser.password}  </td><td> New Password : <input name="password" value="${sessionScope.loggedUser.password}"/><br/>
                <tr><td><fmt:message key="all_users_jsp.first_name"/> :  </td><td>${sessionScope.loggedUser.firstName}  </td><td> New First Name : <input name="firstName" value="${sessionScope.loggedUser.firstName}"/><br/>
                <tr><td><fmt:message key="all_users_jsp.last_name"/> :  </td><td>${sessionScope.loggedUser.lastName}  </td><td> New Last Name : <input name="lastName" value="${sessionScope.loggedUser.lastName}"/><br/>
                <tr><td><fmt:message key="all_users_jsp.blocked"/> :  </td><td>${getUserInfoBlocked}  </td><td><input type="hidden" name="blocked" value="${sessionScope.loggedUser.blocked}" /><br/>
                <tr><td><fmt:message key="all_users_jsp.role"/> :  </td><td>${getUserInfoRole}  </td><td><input type="hidden" name="roleId" value="${sessionScope.loggedUser.roleId}" /><br/>
            </table>
        </div>
       <input value="<fmt:message key="all_users_jsp.edit_profile"/>" type="submit"/></br>
    </form>
        <c:if test="${sessionScope.loggedUser.roleId==3}">
            <fmt:message key="all_users_jsp.fine"/> : ${getUserInfoFine}
        <form action="controller" method="post">
            <input type="hidden" name="command" value="user?payFine"/>
            <input value="<fmt:message key="all_users_jsp.pay_fine"/>" type="submit">
        </form>
        </c:if>

    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="user?deleteProfile"/>
        <input value="<fmt:message key="all_users_jsp.delete_profile"/>" type="submit">
    </form>
</c:if>