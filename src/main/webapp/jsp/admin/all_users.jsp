<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<html>
<body>
<h2>Admin page to obtain all users</h2>
<my:head/><br/>
<c:forEach var="user" items="${requestScope.allUsers}">
    Id : ${user.id}</br>
    Login : ${user.login}</br>
    First Name : ${user.firstName}</br>
    Last Name : ${user.lastName}</br>
    <a href="controller?command=admin%3FshowUserInfo&userId=${user.id}" ><input value="Show User Info" type="submit"/></a>
    </br>
</c:forEach>
<br/>
</body>
</html>
