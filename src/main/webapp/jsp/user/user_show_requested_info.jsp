<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Your Order List : </h2>
<hr/>
<c:forEach var="order" items="${sessionScope.userOrders}">
  Id : ${order.id}</br>
  Status : ${order.status}</br>
  Type : ${order.type}</br>
  Time Book Taken : ${order.timeBookTaken}</br>
  Time Book Should Be Returned : ${order.timeBookShouldBeReturned}<br/>
  Book Id : ${order.bookId}</br>
  <a href="controller?command=showBookInfo&bookId=${order.bookId}"><input value="Show Book Info" type="submit"></a>
  </br>
</c:forEach>
</body>
</html>
