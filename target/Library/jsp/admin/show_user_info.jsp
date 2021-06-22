<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="edit" tagdir="/WEB-INF/tags/UserInfo" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix='my'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<my:head/><br/>
<h2><fmt:message key="show_user_info_jsp"/>:</h2>
    <edit:editIfAdm user="${getUserInfo}"/>
<br/>
<%@ include file="/jspf/footer.jspf" %>
</body>
</html>