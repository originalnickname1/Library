<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@taglib prefix="check" tagdir="/WEB-INF/tags/mainPage" %>
<html>
<body>
<my:head/><br/>
<h1>Welcome to internet library
<check:checkRole user="${sessionScope.loggedUser}"/>

<%@ include file="/jspf/footer.jspf" %>
</body>
</html>