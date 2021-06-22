<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="book" type="db.entity.Book" required="true" %>
<c:if test="${sessionScope.loggedUser.roleId==1}">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="admin?updateBook"/>
       <input type="hidden" name="id" value="${getBookInfo.id}"><br/>
       <fmt:message key="create_book_jsp.new_title"/> : <input name="title" value="${getBookInfo.title}"/><br/>
        <fmt:message key="create_book_jsp.new_year"/>  : <input name="yearOfPublish" value="${getBookInfo.yearOfPublish}"/><br/>
        <fmt:message key="create_book_jsp.new_author"/>  : <input name="author" value="${getBookInfo.author}"/><br/>
        <fmt:message key="create_book_jsp.new_publisher"/>  : <input name="publisher" value="${getBookInfo.publisher}"/><br/>
        <fmt:message key="create_book_jsp.new_amount"/>  : <input name="amount" value="${getBookInfo.amount}"/><br/>
        <fmt:message key="create_book_jsp.new_description"/>  : <input name="description" value="${getBookInfo.description}"><br/>
        <input value="<fmt:message key="create_book_jsp.edit"/>" type="submit"/></br>
    </form>
    <a href="controller?command=admin%3FdeleteBook&bookId=${getBookInfo.id}"><input value="<fmt:message key="create_book_jsp.delete"/>" type="submit"></a><br/>
</c:if>