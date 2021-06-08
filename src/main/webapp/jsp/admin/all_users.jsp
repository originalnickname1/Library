<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Admin page to obtain all users</h2>
<c:forEach var="user" items="${requestScope.allUsers}">
    ${user.getLogin()}</br>
</c:forEach>
</body>
</html>
