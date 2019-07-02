<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task 2</title>
</head>
<body>

<div class="task2div">
    <form method="post" action="Task2">
        <input type="text" name="text" required><br>
        <select name="dropdown">
            <option value="product">Supplier</option>
            <option value="products">Products</option>
        </select>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Supplier</th>
            <th>Products</th>
        </tr>
        <c:forEach items="${task2}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.product}"></c:out></td>
                <td><c:out value="${task.products}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action="index.html">
    <input type="submit" value="Back">
</form>

</body>
</html>
