<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head><title>Internet Library</title></head>
<body>
<my:head/>
<h2><fmt:message key="index_jsp.welcome"/></h2>
<form id="login_form" action="controller" method="post">
    <input type="hidden" name="command" value="login"/>
    <input name="login" required="required"/><br/>
    <input name="password" type="password" required="required"/><br/>
    <input value="<fmt:message key="index_jsp.log_in"/>" type="submit"/><br/>
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="toRegisterJsp">
    <input value="<fmt:message key="index_jsp.register"/>" type="submit">
</form>
<hr/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>