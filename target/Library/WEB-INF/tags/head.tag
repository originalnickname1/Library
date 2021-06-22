<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    input[type=button], input[type=submit], input[type=reset] {
        background: #4CAF50;
        color: #fff;
        border: 1px solid #eee;
        border-radius: 20px;
        box-shadow: 5px 5px 5px #eee;
        text-shadow:none;
        cursor: pointer;
    }
</style>
<form>
    <select name="locale">
        <c:forEach items="${applicationScope.locales}" var="locale">
            <c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>
            <option value="${locale.key}" ${selected}>${locale.value}</option>
        </c:forEach>
    </select>
    <fmt:setLocale value="${param.locale}" scope="session"/>

    <%-- load the bundle (by locale) --%>
    <fmt:setBundle basename="resources"/>

    <%-- set current locale to session --%>
    <c:set var="currentLocale" value="${param.locale}" scope="session"/>
    <input value="Change" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="findBook"/>
    <input name="searchBook" required="required"/><br/>
    <input value="<fmt:message key="head_tag.find"/>" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks"/>
    <input value="<fmt:message key="head_tag.show_all_books"/>" type="submit">
</form>
<c:if test="${sessionScope.loggedUser!=null}">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="toMainPage"/>
        <input value="<fmt:message key="head_tag.to_main_page"/>" type="submit">
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="logout">
        <input value="<fmt:message key="head_tag.logout"/>" type="submit">
    </form>
</c:if>
<c:if test="${sessionScope.loggedUser==null}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="toIndexJsp">
        <input value="<fmt:message key="head_tag.to_login_page"/>" type="submit">
    </form>
</c:if>
<hr>