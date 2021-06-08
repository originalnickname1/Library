<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<html>
<head><title>Internet Library</title></head>
<body>
<h2>Welcome to Internet Library</h2>
<form id="login_form" action="controller" method="post"/>
<input type="hidden" name="command" value="login"/>
<input name ="login"/><br/>
<input name = "password" type="password"/></br>
<input value="Login" type="submit"/>
<hr>
<a href="jsp/registerpage.jsp">Register Now!</a>
</body>
</html>