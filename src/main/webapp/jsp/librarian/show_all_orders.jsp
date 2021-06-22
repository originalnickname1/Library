<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<my:head/><br/>
<h1><fmt:message key="show_all_orders_jsp"/></h1>
</form><br/>
<c:forEach var="order" items="${requestScope.allOrders}">
    Id : ${order.id}</br>
    <fmt:message key="show_all_orders_jsp.status"/> : ${order.status}</br>
    <fmt:message key="show_all_orders_jsp.type"/> : ${order.type}</br>
    <a href="controller?command=showOrderInfo&orderId=${order.id}"><input value="<fmt:message key="show_all_orders_jsp.show_order_info"/>" type="submit"></a>
    </br>
</c:forEach>
<br/>

</body>
</html>
