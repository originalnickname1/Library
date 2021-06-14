<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create Book Page</h2>
<form action="../../controller" method="post"/>
<input type="hidden" name="command" value="librarian?createBook"/>
Title:<input name="title"/><br/>
Year of publish:<input name="year_of_publish"/></br>
Author:<input name="author"/><br/>
Edition:<input name="edition"/><br/>
Amount:<input name="amount"/><br/>
<input value="Create Book" type="submit"/>
</body>
</html>
