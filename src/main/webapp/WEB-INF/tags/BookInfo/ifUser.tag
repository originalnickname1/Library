<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="book" type="db.entity.Book" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId==3}">
    <c:if test="${sessionScope.loggedUser.blocked==0}">
        <form action="controller" method="get">
        <input type="hidden" name="command" value="user?createOrder">
        <input type="hidden" name="bookId" value="${getBookInfo.id}">
        <input value="<fmt:message key="ifUser_tag.order_book"/> " type="submit"><br/>
        <fmt:message key="show_book_info_order_type"/> : <select name="type">
        <option value="READ ROOM">Read Room</option>
        <option value="BORROW BOOK">Borrow Book</option>
    </select><br/><br/>
        </form>
    </c:if>
</c:if>