<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<my:head/><br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="librarian?editOrder"/>
    Id : ${getOrderInfo.id} <input type="hidden" name="orderId" value="${getOrderInfo.id}"><br/>
    <fmt:message key="show_all_orders_jsp.status"/>" : ${getOrderInfo.status} ~~~  New Status<select name = "status">
    <option value="CREATED">Created</option>
    <option value="CONFIRMED">Confirmed</option>
    <option value="CLOSED">Closed</option>
    <option value="CANCELLED">Cancelled</option>
</select><br/>
    <fmt:message key="show_all_orders_jsp.type"/> : ${getOrderInfo.type} <input type="hidden" name="type" value="${getOrderInfo.type}"><br/>
    <fmt:message key="show_all_orders_jsp.library_card_user_id"/> : ${getOrderInfo.libraryCardId} <input type="hidden" name="libraryCardId" value="${getOrderInfo.libraryCardId}"/><br/>
    <fmt:message key="show_all_orders_jsp.time_taken"/> : ${getOrderInfo.timeBookTaken}<input type="hidden" name="timeBookTaken" value="${getOrderInfo.timeBookTaken}"/><br/>
    <fmt:message key="show_all_orders_jsp.time_should_returned"/> : ${getOrderInfo.timeBookShouldBeReturned} <input type="hidden" name="timeBookShouldBeReturned" value="${getOrderInfo.timeBookShouldBeReturned}"/><br/>
    <fmt:message key="show_all_orders_jsp.book_id"/> : ${getOrderInfo.bookId} <input type="hidden" name="bookId" value="${getOrderInfo.bookId}"/><br/>
    <input value="<fmt:message key="show_all_orders_jsp.edit_order"/>" type="submit" /></br>
</form>

</body>
</html>
</body>
</html>
