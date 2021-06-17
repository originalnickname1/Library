<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Books</h1>
<form action="controller" method="get">
Sort by:<select name = "command">
  <option value = "sortByTitle">Title</option>
  <option value ="sortByAuthor">Author</option>
  <option value ="sortByEdition">Edition</option>
  <option value ="sortByYear">Year</option>
  <br/>
  <input value="Sort" type="submit"/>
</select>
</form><br/>
<c:forEach var="book" items="${requestScope.allBooks}">
  Id : ${book.id}</br>
  Title : ${book.title}</br>
  Author : ${book.author}</br>
  Year : ${book.yearOfPublish}</br>
  Amount : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="Show Book Info" type="submit"></a>
  </br>
</c:forEach><br/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>
