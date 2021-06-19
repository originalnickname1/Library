<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${requestScope.foundedBooks}">
  Id : ${book.id}</br>
  Title : ${book.title}</br>
  Author : ${book.author}</br>
  Edition : ${book.edition}</br>
  Year : ${book.yearOfPublish}</br>
  Amount : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="Show Book Info" type="submit"></a>
  </br>
</c:forEach>
</body>
</html>
