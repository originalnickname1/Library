<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
<body>
<h1>ERROR!</h1>
<h2>${sessionScope.errorMessage}</h2><br/>
<a href="index.jsp"><input value="To Login Page" type="submit"></a><br/>
<hr/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</head>