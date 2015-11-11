<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Authentication</title>
</head>
</head>
<body>
<h2>Guest Book</h2>

<form method="POST">
    <p><textarea id="textarea" value="post" name="post" maxlength=500
                 style="width: 200px; height: 100px;"></textarea></p>

    <p><input type="submit" name = "Register now" value = "Register now"></p>
    <br>
    <br>
<c:if test="${not empty list}">

    <c:forEach items="${list}" var="post">
    <p><b>${post.getUsername()}:</b> <br>
            ${post.getPost()}
    </p>
    </c:forEach>
    </c:if>

</body>
</html>
