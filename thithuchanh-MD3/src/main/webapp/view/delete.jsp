<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
  <a href="/student">Back to customer list</a>
</p>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getName()}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${requestScope["student"].getBirth()}</td>
      </tr>
      <tr>
        <td>Address: </td>
        <td>${requestScope["student"].getAddress()}</td>
      </tr>
      <tr>
        <td>Phone: </td>
        <td>${requestScope["student"].getPhone()}</td>
      </tr>
      <tr>
        <td>Email: </td>
        <td>${requestScope["student"].getEmail()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete customer"></td>
        <td><a href="/student">Back to customer list</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>