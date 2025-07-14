<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="/css/login.css" />
</head>
<body>
<div class="container">
    <h2>Login</h2>

    <!-- Show error message if present -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

   <form method="post" action="/dummyLogin">

        <label>Username:</label><br>
        <input id="username" type="text" name="username" required /><br><br>

        <label>Password:</label><br>
        <input id="userpassword" type="password" name="password" required /><br><br>

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
      