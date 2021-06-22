<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<my:head/><br/>

    <form action="../../controller" method="post"/>
    <input type="hidden" name="command" value="admin?createBook"/>
    <fmt:message key="create_book_jsp.title"/>:<input name="title"/><br/>
    <fmt:message key="create_book_jsp.year"/>:<input name="year_of_publish"/></br>
    <fmt:message key="create_book_jsp.author"/>:<input name="author"/><br/>
    <fmt:message key="create_book_jsp.publisher"/>:<input name="edition"/><br/>
    <fmt:message key="create_book_jsp.amount"/>:<input name="amount"/><br/>
    <fmt:message key="create_book_jsp.description"/>:<input name="description"><br/>
    <input value="<fmt:message key="create_book_jsp.create"/>" type="submit"/><br/>
</form>
<form action="../../controller" method="post">
    <input type="hidden" name="command" value="toMainPage"/>
    <input value="Back" type="submit">
</form>
<br/>
</body>
</html>