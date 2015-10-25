<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<h1>Log In </h1>

<form method="POST">
    <p> Email
        <input class="field" type="text" name="email"></p>

    <p>Password
        <input class="field" type="text" name="password"></p> <br>
    <input id="button" type="submit" value="Enter" name="enter">
</form>

<br>
<br>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
</body>
</html>
