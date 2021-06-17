<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="book" type="db.entity.Book" required="true" %>
<c:if test="${sessionScope.userRoleId==1}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="admin?updateBook"/>
       <input type="hidden" name="id" value="${getBookInfo.id}"><br/>
        New Title : <input name="title" value="${getBookInfo.title}"/><br/>
        New Year Of Publish : <input name="yearOfPublish" value="${getBookInfo.yearOfPublish}"/><br/>
        New Author : <input name="author" value="${getBookInfo.author}"/><br/>
        New Publisher : <input name="publisher" value="${getBookInfo.publisher}"/><br/>
        New Amount : <input name="amount" value="${getBookInfo.amount}"/><br/>
        New Description : <input name="description" value="${getBookInfo.description}"><br/>
        <input value="Edit Book" type="submit"/></br>
    </form>
    <a href="controller?command=admin%3FdeleteBook&bookId=${getBookInfo.id}"><input value="Delete Book" type="submit"></a><br/>
</c:if>