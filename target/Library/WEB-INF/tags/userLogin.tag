<%@ attribute name="user" type="db.entity.User" required="true" %>

<form action="controller" method="post">
    <a href="controller?command=admin%3FshowUserInfo&userId=${user.id}" ><input value="Show Profile" type="submit"/></a>
</form>