<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="edit" tagdir="/WEB-INF/tags/UserInfo" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<my:head/><br/>
<edit:editIfUser user="${sessionScope.loggedUser}"/>
</body>
</html>
