<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset=\"utf-8\">
<body>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
<form method="POST"><p><input type="text" name="email"> Mail<br>
    <input type="text" name="password">Password</p>

    <p><input type="submit"></p>

    <p><input type="radio" value="Women" name="sex"> Man</p>

    <p><input type="radio" value="Woman" name="sex">Woman</p>

    <p><input type="checkbox" name="checkbox" style="height:10px; width:10px;">Subscription</form>
</p>
</body>
</html>
