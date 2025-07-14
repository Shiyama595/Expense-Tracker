<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Budget</title>
       <link rel="stylesheet" href="/css/budget.css" />
</head>
<body>
   <div class="logout-btn">
        <form action="/logout" method="post">
            <input type="submit" value="Logout" />
        </form>
    </div>
   
    <form class="form-class" action="/set-budget" method="post">
    <h2>Enter Your Salary/Budget</h2>
        <label for="budget"></label>
        <input type="number" step="0.01" name="budget" required />
        <br/><br/>
        <input type="submit" value="Start Tracking" />
    </form>
</body>
</html>
