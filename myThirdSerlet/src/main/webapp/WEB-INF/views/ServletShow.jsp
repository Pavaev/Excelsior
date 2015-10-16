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
<table border="7"  cellpadding="5">
<tr>
    <th>Email</th>
    <th>Password</th>
    <th>Sex</th>
    <th>Subscription</th>
</tr>

<c:forEach items="${list}" var="user">
    <tr>
   <td> ${user.getEmail()}</td>
    <td> ${user.getPassword()}</td>
    <td> ${user.getSex()}</td>
    <td> ${user.getSubscription()}</td>
    </tr>


</c:forEach>
</table>
</body>
</html>
