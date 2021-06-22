<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<c:forEach var="book" items="${sessionScope.foundedBooks}">
  <fmt:message key="show_all_orders_jsp.book_id"/> : ${book.id}</br>
  <fmt:message key="create_book_jsp.year"/> : ${book.title}</br>
  <fmt:message key="create_book_jsp.author"/> : ${book.author}</br>
  <fmt:message key="create_book_jsp.publisher"/> : ${book.publisher}</br>
  <fmt:message key="create_book_jsp.year"/> : ${book.yearOfPublish}</br>
  <fmt:message key="create_book_jsp.amount"/> : ${book.amount}</br>
  <a href="controller?command=showBookInfo&bookId=${book.id}"><input value="<fmt:message key="show_all_orders_jsp.show_book_info"/>" type="submit"></a>
  </br>
</c:forEach>

</body>
</html>
