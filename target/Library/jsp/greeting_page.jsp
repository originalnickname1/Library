<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h1>Welcome to internet library <c:out value="${loggedUser}"/> </h1>
<h2> Your role is : <c:out value="${userRole}"/> ! </h2>
</body>
</html>