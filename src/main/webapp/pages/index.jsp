<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Expense Tracker</title>
       <link rel="stylesheet" href="/css/index.css" />
</head>
<body>
<div style="position: absolute; top: 20px; right: 20px; display: flex; gap: 10px;">
    <form action="/set-budget" method="get">
        <input type="submit" value="Edit Salary" 
               style="background-color: #f57c00; color: white; padding: 6px 12px; border: none; border-radius: 4px; cursor: pointer;" />
    </form>
    <form action="/logout" method="post">
        <input type="submit" value="Logout"
               style="background-color: #f44336; color: white; padding: 6px 12px; border: none; border-radius: 4px; cursor: pointer;" />
    </form>
</div>

    
    <h2>Transaction History</h2>
    <h3>Your Budget: ₹${budget}</h3>
    
    <a href="/add">+ Add Transaction</a><br/><br/>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${listExpenses}" var="expense">
            <tr>
                <td>${expense.title}</td>
                <td>${expense.type}</td>
                <td>${expense.amount}</td>
                <td>${expense.date}</td>
                <td>
                    <a href="/edit/${expense.id}">Edit</a> |
                    <a href="/delete/${expense.id}" onclick="return confirm('Are you sure you want to delete this ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
