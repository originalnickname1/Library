<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<c:forEach var="book" items="${sessionScope.foundedBooks}">
  Id : ${book.id}</br>
  Title : ${book.title}</br>
  Author : ${book.author}</br>
  Edition : ${book.publisher}</br>
  Year : ${book.yearOfPublish}</br>
  Amount : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="Show Book Info" type="submit"></a>
  </br>
</c:forEach>

</body>
</html>
