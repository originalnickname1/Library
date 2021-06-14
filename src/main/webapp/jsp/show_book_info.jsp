
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Admin page to obtain all users</h2>
<form action="controller" method="get">
    <input type="hidden" name="command" value="showBookInfo"/>
    Id : ${gerBookInfo.id} <input type="hidden" name="id" value="${getUserInfo.id}"><br/>
    Title : ${gerBookInfo.title} ~~~ New Login : <input name="login" value="${getUserInfo.login}"/><br/>
    Year Of Publish : ${gerBookInfo.yearOfPublish} ~~~ New Password : <input name="password" value="${getUserInfo.password}"/><br/>
    Author : ${gerBookInfo.author} ~~~ New First Name : <input name="firstName" value="${getUserInfo.firstName}"/><br/>
    Edition : ${gerBookInfo.edition} ~~~ New Last Name : <input name="lastName" value="${getUserInfo.lastName}"/><br/>
    Amount : ${gerBookInfo.amount} ~~~ New Last Name : <input name="lastName" value="${getUserInfo.lastName}"/><br/>
</body>
</html>
