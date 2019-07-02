<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task 3</title>
</head>
<body>

<div class ="task3div">
    <form method="post" action="Task3">
        Company<input type="text" name="text" required><br>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Company</th>
        </tr>
        <c:forEach items="${task3}" var="task" varStatus="status">
            <tr>
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
