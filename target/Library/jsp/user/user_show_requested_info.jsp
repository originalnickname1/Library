<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<h2><fmt:message key="show_requested_info_jsp"/> : </h2>
<hr/>
<c:forEach var="order" items="${sessionScope.userOrders}">
  Id : ${order.id}</br>
  <fmt:message key="show_all_orders_jsp.status"/> : ${order.status}</br>
  <fmt:message key="show_all_orders_jsp.type"/> : ${order.type}</br>
  <fmt:message key="show_all_orders_jsp.time_taken"/> : ${order.timeBookTaken}</br>
  <fmt:message key="show_all_orders_jsp.time_should_returned"/> : ${order.timeBookShouldBeReturned}<br/>
  <fmt:message key="show_all_orders_jsp.book_id"/> : ${order.bookId}</br>
  <a href="controller?command=showBookInfo&bookId=${order.bookId}"><input value="<fmt:message key="show_all_orders_jsp.show_book_info"/>" type="submit"></a>
  </br>
</c:forEach>

</body>
</html>
