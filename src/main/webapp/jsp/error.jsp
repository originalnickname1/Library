<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<head>

<body>
<my:head/><br/>
<h1>ERROR!</h1>
<h2>${sessionScope.errorMessage}</h2><br/>
<hr/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</head>