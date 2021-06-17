<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="librarian?editOrder"/>
    Id : ${getOrderInfo.id} <input type="hidden" name="orderId" value="${getOrderInfo.id}"><br/>
    Status : ${getOrderInfo.status} ~~~  New Status<select name = "status">
    <option value="CREATED">Created</option>
    <option value="CONFIRMED">Confirmed</option>
    <option value="CLOSED">Closed</option>
    <option value="CANCELLED">Cancelled</option>
</select><br/>
    Type : ${getOrderInfo.type} ~~~ New Type : <select name = "type">
    <option value="READ ROOM">Read Room</option>
    <option value="BORROW BOOK">Borrow Book</option>
    </select><br/>
    Library Card/User Id : ${getOrderInfo.libraryCardId} <input type="hidden" name="libraryCardId" value="${getOrderInfo.libraryCardId}"/><br/>
    Time Book Taken: ${getOrderInfo.timeBookTaken}<input type="hidden" name="timeBookTaken" value="${getOrderInfo.timeBookTaken}"/><br/>
    Time Book Should be Returned : ${getOrderInfo.timeBookShouldBeReturned} <input type="hidden" name="timeBookShouldBeReturned" value="${getOrderInfo.timeBookShouldBeReturned}"/><br/>
    Book Id : ${getOrderInfo.bookId} <input type="hidden" name="bookId" value="${getOrderInfo.bookId}"/><br/>
    <input value="Edit Order" type="submit" /></br>
</form>
<my:logout/>
</body>
</html>
</body>
</html>
