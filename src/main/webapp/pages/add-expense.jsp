<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Expense</title>
       <link rel="stylesheet" href="/css/add.css" />
</head>
<body>
    <div class="logout-btn">
        <form action="/logout" method="post">
            <input type="submit" value="Logout" />
        </form>
    </div>

    <form action="/save" method="post">
        <h2>${expense.id == null ? "Add" : "Edit"} Transaction</h2>
        <input type="hidden" name="id" value="${expense.id}" />

        Title: <input type="text" name="title" value="${expense.title}" required/><br/>

        Amount: <input type="number" step="0.01" name="amount" value="${expense.amount}" required/><br/>

        Date: <input type="date" name="date" value="${expense.date}" required/><br/>

        Type:
        <select name="type" required>
            <option value="Income" ${expense.type == 'Income' ? 'selected' : ''}>Income</option>
            <option value="Expense" ${expense.type == 'Expense' ? 'selected' : ''}>Expense</option>
        </select><br/>

        <input type="submit" value="Save" />
    </form>
</body>
</html>
