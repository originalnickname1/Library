<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head><title>Internet Library</title></head>
<body>
<h2>Welcome to Internet Library</h2>
<my:head/>
<form id="login_form" action="controller" method="post">
    <input type="hidden" name="command" value="login"/>
    <input name="login"/><br/>
    <input name="password" type="password"/></br>
    <input value="Login" type="submit"/><br/>
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="toRegisterJsp">
    <input value="Register Now" type="submit">
</form>
<hr/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>