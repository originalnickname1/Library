<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@taglib prefix="check" tagdir="/WEB-INF/tags/mainPage" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<my:head/><br/>
<h1><fmt:message key="index_jsp.welcome"/>
<check:checkRole user="${sessionScope.loggedUser}"/>

<%@ include file="/jspf/footer.jspf" %>
</body>
</html>