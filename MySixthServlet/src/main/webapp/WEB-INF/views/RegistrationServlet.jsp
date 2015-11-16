<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <meta charset="utf-8">

</head>


<body>

<form method="POST"><p><input type="text" name="email"> Mail<br>
    <input type="text" name="password">Password</p>

    <p><input type="submit" name = "Register now" value = "Register now"></p>

    <p><input type="radio" value="Man" name="radio"> Man</p>

    <p><input type="radio" value="Woman" name="radio">Woman</p>

    <p><input type="checkbox" name="checkbox" style="height:10px; width:10px;">Subscription </p>
    <br>
    About Myself


    <p><textarea id="textarea" value="aboutMyself" name="aboutMyself"
                 style="width: 300px; height: 150px;"
                 onchange="countChar()" onkeyup="countChar()">

    </textarea><br/>
        <input type="text" id="count" value="0" readonly/>

</form>

<br>
<br>
<c:if test="${not empty message}">

    <h3>${message}</h3>
</c:if>

<script type="text/javascript">function countChar() {
    var count = document.getElementById("count");
    var textarea = document.getElementById("textarea");
    count.value = textarea.value.length;}</script>

<!-- <script type="text/javascript" src="<c:url value="/js/countChar.js"/>"></script> -->
</body>


</html>
