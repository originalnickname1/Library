<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<my:head/><br/>
<h2>Register Page!</h2>
<form action="controller" method="post">
<input type="hidden" name="command" value="register"/>
    <div>
        <style>
            table,th,td{
                border: 1px solid black;
            }
        </style>
        <table>
            <tr><td><fmt:message key="all_users_jsp.login"/> : </td><td><input name="login" required="required"/></td></tr>
            <tr><td><fmt:message key="all_users_jsp.password"/> : </td><td><input name="password" type="password" required="required"/></td></tr>
            <tr><td><fmt:message key="all_users_jsp.first_name"/> : </td><td><input name="firstName" required="required"/></td></tr>
            <tr><td><fmt:message key="all_users_jsp.last_name"/> : </td><td><input name="lastName" required="required"/></td></tr>
        </table>
    </div><br/>
<input value="<fmt:message key="index_jsp.register"/>" type="submit"/><br/>
</form>
<hr/>
    <%@ include file="/jspf/footer.jspf" %>
</body>
</html>