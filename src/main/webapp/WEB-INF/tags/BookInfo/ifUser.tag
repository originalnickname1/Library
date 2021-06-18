<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="book" type="db.entity.Book" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId==3 && sessionScope.loggedUser.blocked==0}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="user?createOrder">
        <input type="hidden" name="bookId" value="${getBookInfo.id}">
        <input value="Order A Book" type="submit"><br/>
        Order Type : <select name="type">
        <option value="READ ROOM">Read Room</option>
        <option value="BORROW BOOK">Borrow Book</option>
    </select><br/><br/>
</c:if>