<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">
</head>
<body>
<br>
<table border="7" cellpadding="5">
    <tr>
        <th>Email</th>
        <th>Password</th>
        <th>Sex</th>
        <th>Subscription</th>
        <th>Information</th>
    </tr>


    <tr>
        <td>${user.getEmail()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getSex()}</td>
        <td>${user.getSubscription()}</td>
        <td>${user.getaboutMyself()}</td>
    </tr>
    <form method="POST">
    <input id="button" type="submit" value="Logout" name="Logout">
        </form>
    <br>
    <br>
    <c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>


</table>
</body>
</html>
