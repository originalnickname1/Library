<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="book" type="db.entity.Book" required="true" %>
<c:if test="${sessionScope.userRoleId==2}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="librarian?updateBook"/>
       <input type="hidden" name="id" value="${getBookInfo.id}"><br/>
        New Title : <input name="title" value="${getBookInfo.title}"/><br/>
        New Year Of Publish : <input name="yearOfPublish" value="${getBookInfo.yearOfPublish}"/><br/>
        New Author : <input name="author" value="${getBookInfo.author}"/><br/>
        New Edition : <input name="edition" value="${getBookInfo.edition}"/><br/>
        New Amount : <input name="amount" value="${getBookInfo.amount}"/><br/>
        <input value="Edit Book" type="submit"/></br>
    </form>
</c:if>