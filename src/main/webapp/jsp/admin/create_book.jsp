<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create Book Page</h2>
<form action="../../controller" method="post"/>
<input type="hidden" name="command" value="admin?createBook"/>
Title:<input name="title"/><br/>
Year of publish:<input name="year_of_publish"/></br>
Author:<input name="author"/><br/>
Edition:<input name="edition"/><br/>
Amount:<input name="amount"/><br/>
Description:<input name="description"><br/>
<input value="Create Book" type="submit"/>
<my:logout/><br/>
</body>
</html>
