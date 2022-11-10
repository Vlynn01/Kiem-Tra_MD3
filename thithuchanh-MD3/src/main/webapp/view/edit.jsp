<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/student">Back to customer list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name" value="${requestScope["student"].getName()}"></td>
      </tr>
      <tr>
        <td>Birth: </td>
        <td><input type="text" name="birth" id="birth" value="${requestScope["student"].getBirth()}"></td>
      </tr>
      <tr>
        <td>Address: </td>
        <td><input type="text" name="address" id="address" value="${requestScope["student"].getAddress()}"></td>
      </tr>
      <tr>
        <td>Phone: </td>
        <td><input type="text" name="phone" id="phone" value="${requestScope["student"].getPhone()}"></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email" value="${requestScope["student"].getEmail()}"></td>
      </tr>
      <tr>
        <td>Class:</td>
        <td><select name="class" id="class" value="${requestScope["student"].getClassS()}">
          <option value="1">C0322G1</option>
          <option value="2">C0433C2</option>
          <option value="3">C0522H1</option>
        </select></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update customer"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>