<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Books</h1>
<c:forEach var="book" items="${requestScope.allBooks}">
  Id : ${book.id}</br>
  Title : ${book.title}</br>
  Author : ${book.author}</br>
  Amount : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="Show Book Info" type="submit"></a>
  </br>
</c:forEach>
</body>
</html>
