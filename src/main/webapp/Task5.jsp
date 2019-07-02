<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task 5</title>
</head>
<body>

<div class ="task5div">
    <form method="post" action="Task5">
        <input type="text" name="text" required><br>
        <select name="dropdown">
            <option value="company">Company</option>
            <option value="product">Product</option>
            <option value="price">Price</option>
        </select>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Company</th>
            <th>Product</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${task5}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.company}"></c:out></td>
                <td><c:out value="${task.product}"></c:out></td>
                <td><c:out value="${task.price}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action="index.html">
    <input type="submit" value="Back">
</form>

</body>
</html>
