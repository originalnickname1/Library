<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" type="db.entity.User" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId==1}">
    <a href="controller?command=admin%3FshowUserInfo&userId=${sessionScope.loggedUser.id}" >${sessionScope.loggedUser.login}</a></h1>
    <h1>Admin Menu</h1>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="admin?getAllUsers"/>
        <input value="Get All Users" type="submit"/><br/>
    </form>
    <a href="jsp/admin/create_book.jsp"><input value="Create Book" type="submit"/></a>
    <br/>
</c:if>
<c:if test="${sessionScope.loggedUser.roleId==2}">
    <a href="controller?command=showProfile&userId=${sessionScope.loggedUser.id}" >${sessionScope.loggedUser.login}</a></h1>
    <h1>Librarian Menu</h1>
    </br>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="librarian?getAllOrders"/>
        <input value="Show all orders" type="submit">
    </form>
</c:if>
<c:if test="${sessionScope.loggedUser.roleId==3}">
    <a href="controller?command=showProfile&userId=${sessionScope.loggedUser.id}"> ${sessionScope.loggedUser.login}</a></h1>
    <h1>User Menu</h1>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="showOrdersById">
        <input value="Show My Orders" type="submit">
    </form>
</c:if>