<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId==1}">
    <a href="controller?command=admin%3FshowUserInfo&userId=${sessionScope.loggedUser.id}" >${sessionScope.loggedUser.login}</a></h1>
    <h1><fmt:message key="checkRole_tag.admin"/></h1>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="admin?getAllUsers"/>
        <input value="<fmt:message key="all_users_jsp.all_users"/>" type="submit"/><br/>
    </form>
    <a href="jsp/admin/create_book.jsp"><input value="<fmt:message key="checkRole_tag.create_book"/>" type="submit"/></a>
    <br/>
</c:if>
<c:if test="${sessionScope.loggedUser.roleId==2}">
    <a href="controller?command=showProfile&userId=${sessionScope.loggedUser.id}" >${sessionScope.loggedUser.login}</a></h1>
    <h1><fmt:message key="checkRole_tag.librarian"/></h1>
    </br>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="librarian?getAllOrders"/>
        <input value="<fmt:message key="checkRole_tag.show_all_orders"/>" type="submit">
    </form>
</c:if>
<c:if test="${sessionScope.loggedUser.roleId==3}">
    <a href="controller?command=showProfile&userId=${sessionScope.loggedUser.id}"> ${sessionScope.loggedUser.login}</a></h1>
    <h1><fmt:message key="checkRole_tag.user"/></h1>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="showOrdersById">
        <input value="<fmt:message key="checkRole_tag.show_my_orders"/>" type="submit">
    </form>
    <a href="controller?command=showBooksOnAcc&userId=${sessionScope.loggedUser.id}"><input value="<fmt:message key="checkRole_tag.user_show_books_on_acc"/> " type="submit"></a>
    <br/>
</c:if>