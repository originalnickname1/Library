<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<h2>Register Page!</h2>
<form action="../controller" method="post">
<input type="hidden" name="command" value="register"/>
Login:<input name="login"/><br/>
Password:<input name="password" type="password"/></br>
First Name:<input name="firstName"/><br/>
Last Name:<input name="lastName"/><br/>
<input value="Register" type="submit"/><br/>
</form>
<a href="../index.jsp"><input value="To Login Page" type="submit"></a><br/>
<hr/>
    <%@ include file="/jspf/footer.jspf" %>
</body>
</html>