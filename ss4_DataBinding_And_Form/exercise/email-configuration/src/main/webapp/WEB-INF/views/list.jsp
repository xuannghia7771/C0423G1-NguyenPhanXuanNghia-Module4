<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 016 16/08/2023
  Time: 04:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>Language</th>
            <th>Page Size</th>
            <th>Spams filter</th>
            <th>Signature</th>
        </tr>
        <tr>
            <c:forEach items="${list}" var="mail">
                <td>${mail.language}</td>
                <td>${mail.pageSize}</td>
                <td>${mail.spam}</td>
                <td>${mail.signature}</td>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
