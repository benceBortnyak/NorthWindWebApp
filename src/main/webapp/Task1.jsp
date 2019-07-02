<%--
  Created by IntelliJ IDEA.
  User: bence
  Date: 6/14/19
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task 1</title>
</head>
<body>

<div class ="task1div">
<form method="post" action="Task1">
    <input type="text" name="text" required><br>
    <select name="dropdown">
        <option value="product">Product</option>
        <option value="company">Company</option>
    </select>
    <button type="submit">Search</button>
</form>

    <table>
        <tr>
            <th>Product</th>
            <th>Company</th>
        </tr>
        <c:forEach items="${task1}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.product}"></c:out></td>
                <td><c:out value="${task.company}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action="index.html">
    <input type="submit" value="Back">
</form>

</body>
</html>
