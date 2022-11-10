<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Quản lý học viên</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Quản lý học viên codegym</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Address</th>
            <th>Date of Birth</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>ClassRoom</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <button><a href="/home?action=create">Create</a></button>
        <form action="/home?action=search" method="post">
            <input name="search">
            <button type="submit">Search</button>
        </form>
        <form method="post">
            <c:forEach items="${listHV}" var="hv">
                <tr>
                    <td>${hv.id}</td>
                    <td>${hv.name}</td>
                    <td>${hv.getAddress()}</td>
                    <td>${hv.date}</td>
                    <td>${hv.phone}</td>
                    <td>${hv.email}</td>
                    <td>${hv.className}</td>
                    <td><button>edit</button></td>
                    <td><button><a href="/home?action=delete&&id=${hv.id}">Delete</a></button></td>
                </tr>
                </form>
            </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>