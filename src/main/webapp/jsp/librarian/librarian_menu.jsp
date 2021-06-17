<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Librarian Menu</h1>
</br>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks"/>
    <input value="Show all books" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="librarian?getAllOrders"/>
    <input value="Show all orders" type="submit">
</form>
<my:logout/>
</body>
</html>
