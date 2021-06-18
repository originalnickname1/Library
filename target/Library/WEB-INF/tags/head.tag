<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="controller" method="get">
    <input type="hidden" name="command" value="findBook"/>
    <input name="searchBook"/><br/>
    <input value="Find" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks"/>
    <input value="Show All Books" type="submit">
</form>
<c:if test="${sessionScope.loggedUser!=null}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="toMainPage"/>
        <input value="To Main Page" type="submit">
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="logout">
        <input value="Logout" type="submit">
    </form>
</c:if>
<c:if test="${sessionScope.loggedUser==null}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="toIndexJsp">
        <input value="To Login Page" type="submit">
    </form>
</c:if>
<hr>