<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 016 16/08/2023
  Time: 11:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Language</th>
        <th>sizePage</th>
        <th>spams</th>
        <th>signature</th>
        <th>detail</th>
    </tr>
    <c:forEach var="mail" items="${mailList}">
        <tr>
            <td>${mail.id}</td>
            <td>${mail.languages}</td>
            <td>${mail.pageSize}</td>
            <td>${mail.spam}</td>
            <td>${mail.signature}</td>
            <td> <a href="/home/edit?id=${mail.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<p>${message}</p>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
