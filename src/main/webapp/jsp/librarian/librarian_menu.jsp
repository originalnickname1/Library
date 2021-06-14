<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Librarian Menu</h1>
<a href="jsp/librarian/create_book.jsp" ><input value="Create Book" type="submit"/></a>
</br>
<form action="controller" method="get">
    <input type="hidden" name="command" value="getAllBooks"/>
    <input value="Show all books" type="submit">
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="logout">
    <input value="Logout" type="submit">
</form>
</body>
</html>
