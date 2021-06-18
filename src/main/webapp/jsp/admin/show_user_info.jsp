<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="edit" tagdir="/WEB-INF/tags/UserInfo" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>

<html>
<body>
<my:head/><br/>
<h2>User Info:</h2>
    <edit:editIfAdm user="${getUserInfo}"/>
<br/>
</body>
</html>
