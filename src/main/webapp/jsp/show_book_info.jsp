<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="show" tagdir="/WEB-INF/tags/BookInfo" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<h2><fmt:message key="show_all_orders_jsp.show_book_info"/> : </h2>
<form action="controller" method="get">
    <input type="hidden" name="command" value="showBookInfo"/>
    ID : ${getBookInfo.id} <br/>
    <fmt:message key="create_book_jsp.title"/> : ${getBookInfo.title} <br/>
    <fmt:message key="create_book_jsp.year"/> : ${getBookInfo.yearOfPublish} <br/>
    <fmt:message key="create_book_jsp.author"/> : ${getBookInfo.author} <br/>
    <fmt:message key="create_book_jsp.publisher"/> : ${getBookInfo.publisher} <br/>
    <fmt:message key="create_book_jsp.amount"/> : ${getBookInfo.amount} <br/>
    <fmt:message key="create_book_jsp.description"/> : ${getBookInfo.description}
    </form>
<show:ifAdm book="${getBookInfo}"></show:ifAdm>
<show:ifUser book="${getBookInfo}"></show:ifUser>
    <%@ include file="/jspf/footer.jspf" %>
</body>
</html>
