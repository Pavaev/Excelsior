<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8"></head>
<body>

<form method="POST"><p><input type="text" name="email"> Mail<br>
    <input type="text" name="password">Password</p>

    <p><input type="submit"></p>

    <p><input type="radio" value="Women" name="sex"> Man</p>

    <p><input type="radio" value="Woman" name="sex">Woman</p>

    <p><input type="checkbox" name="checkbox" style="height:10px; width:10px;">Subscription
</form>
</p>
<br>
<c:if test="${not empty message}">

    <h4>${message}</h4>
</c:if>
</body>

</body>
</html>
