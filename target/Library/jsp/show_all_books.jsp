<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<h1><fmt:message key="show_all_books_jsp"/> </h1>
<form action="controller" method="get">
  <fmt:message key="show_all_books_jsp.sort_by"/>:<select name = "command">
  <option value = "sortByTitle"><fmt:message key="create_book_jsp.title"/></option>
  <option value ="sortByAuthor"><fmt:message key="create_book_jsp.author"/></option>
  <option value ="sortByEdition"><fmt:message key="create_book_jsp.publisher"/></option>
  <option value ="sortByYear"><fmt:message key="create_book_jsp.year"/></option>
  <br/>
  <input value="<fmt:message key="show_all_books_jsp.sort"/>" type="submit"/>
</select>
</form><br/>
<c:forEach var="book" items="${requestScope.allBooks}">
  Id : ${book.id}</br>
  <fmt:message key="create_book_jsp.title"/> : ${book.title}</br>
  <fmt:message key="create_book_jsp.author"/> : ${book.author}</br>
  <fmt:message key="create_book_jsp.year"/> : ${book.yearOfPublish}</br>
  <fmt:message key="create_book_jsp.amount"/> : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="<fmt:message key="show_all_orders_jsp.show_book_info"/>" type="submit"></a>
  </br>
</c:forEach><br/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>
