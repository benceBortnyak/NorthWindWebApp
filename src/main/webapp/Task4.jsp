<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task 4</title>
</head>
<body>

<div class="task4div">
    <form method="post" action="Task4">
        <input type="text" name="text" required><br>
        <select name="dropdown">
            <option value="company">Company</option>
            <option value="orderId">Order ID</option>
        </select>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Company</th>
            <th>Order Id</th>
        </tr>
        <c:forEach items="${task4}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.company}"></c:out></td>
                <td><c:out value="${task.orderId}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action="index.html">
    <input type="submit" value="Back">
</form>

</body>
</html>
