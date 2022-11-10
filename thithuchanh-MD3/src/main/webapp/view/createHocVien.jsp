<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/home?action=create">
    Add new Student
    <table>
        <tr>

            <td><input name="name"></td>
        </tr>
        <tr>

            <td><input name="address"></td>
        </tr>
        <tr>

            <td><input name="date" type="date"></td>
        </tr>

        <tr>

            <td><input name="phone"></td>
        </tr>
        <tr>

            <td><input name="email"></td>
        </tr>

        <tr>
            <td>
                <select name="idClassRoom">
                    <c:forEach items="${listClass}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit">Create</button>
</form>
</body>
</html>


