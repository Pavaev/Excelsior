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
    </tr>


    <tr>
        <td><c:out value="${user.getEmail()}"></c:out></td>
        <td><c:out value="${user.getPassword()}"></c:out></td>
        <td><c:out value="${user.getSex()}"></c:out></td>
        <td><c:out value="${user.getSubscription()}"></c:out></td>
    </tr>
    <br>
    <br>
    <c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>


</table>
</body>
</html>
