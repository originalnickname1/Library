<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<html>
<body>
<h1>Welcome to internet library
    <a href="controller?command=admin%3FshowUserInfo&userId=${sessionScope.userId}" ><input value="${sessionScope.loggedUser}" type="submit"/></a>
</h1>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks">
    <input value="Show All Books" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="showOrdersById">
    <input value="Show My Orders" type="submit">
</form>
<my:logout/><br/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>