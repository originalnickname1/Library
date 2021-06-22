<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h2><fmt:message key="all_users_jsp.all_users"/></h2>
<my:head/><br/>
<c:forEach var="user" items="${requestScope.allUsers}">
    Id : ${user.id}</br>
    <fmt:message key="all_users_jsp.login"/> : ${user.login}</br>
    <fmt:message key="all_users_jsp.first_name"/> : ${user.firstName}</br>
    <fmt:message key="all_users_jsp.last_name"/> : ${user.lastName}</br>
    <a href="controller?command=admin%3FshowUserInfo&userId=${user.id}" >
        <input value="<fmt:message key="all_users_jsp.show_user_info"/>" type="submit"/></a>
    </br>
</c:forEach>
<br/>
</body>
</html>
