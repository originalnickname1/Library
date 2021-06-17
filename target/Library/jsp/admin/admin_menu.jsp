<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<html>
<body>
<h2>Admin menu page</h2>
<form action="controller" method="get">
<input type="hidden" name="command" value="admin?getAllUsers"/>
<input value="Get All Users" type="submit"/><br/>
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks"/>
    <input value="Show All Books" type="submit" >
</form>
<a href="jsp/admin/create_book.jsp" ><input value="Create Book" type="submit"/></a>
<my:logout/><br/>
</body>
</html>
