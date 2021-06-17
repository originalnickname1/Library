<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<html>
<head>
    <title>All Orders</title>
</head>
<body>
<h1>All Orders</h1>
</form><br/>
<c:forEach var="order" items="${requestScope.allOrders}">
    Id : ${order.id}</br>
    Status : ${order.status}</br>
    Type : ${order.type}</br>
    <a href="controller?command=showOrderInfo&orderId=${order.id}"><input value="Show Order Info" type="submit"></a>
    </br>
</c:forEach>
<br/>
<my:logout/>
</body>
</html>
