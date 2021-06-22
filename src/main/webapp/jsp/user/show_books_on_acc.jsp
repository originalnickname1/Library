<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<h1>Books on your account:</h1>
<hr/>
<c:forEach var="order" items="${sessionScope.confirmedOrders}">
  Id : ${order.id}</br>
  <fmt:message key="show_all_orders_jsp.status"/> : ${order.status}</br>
  <fmt:message key="show_all_orders_jsp.type"/> : ${order.type}</br>
  <fmt:message key="show_all_orders_jsp.time_taken"/> : ${order.timeBookTaken}</br>
  <fmt:message key="show_all_orders_jsp.time_should_returned"/> : ${order.timeBookShouldBeReturned}<br/>
  <fmt:message key="show_all_orders_jsp.book_id"/> : ${order.bookId}</br>
  <a href="controller?command=showBookInfo&bookId=${order.bookId}"><input value="<fmt:message key="show_all_orders_jsp.show_book_info"/>" type="submit"></a>
  <a href="controller?command=user?returnBook&bookId=${order.bookId}&orderId=${order.id}"><input value="<fmt:message key="show_all_orders_jsp.return_book"/>" type="submit"></a>
  </br>
</c:forEach>
</body>
</html>
