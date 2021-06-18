<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="show" tagdir="/WEB-INF/tags/BookInfo" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<h2>Book Info: </h2>
<form action="controller" method="get">
    <input type="hidden" name="command" value="showBookInfo"/>
    Id : ${getBookInfo.id} <br/>
    Title : ${getBookInfo.title} <br/>
    Year Of Publish : ${getBookInfo.yearOfPublish} <br/>
    Author : ${getBookInfo.author} <br/>
    Publisher : ${getBookInfo.publisher} <br/>
    Amount : ${getBookInfo.amount} <br/>
    Description : ${getBookInfo.description}
    </form>
<show:ifAdm book="${getBookInfo}"></show:ifAdm>
<show:ifUser book="${getBookInfo}"></show:ifUser>
    <%@ include file="/jspf/footer.jspf" %>
</body>
</html>
