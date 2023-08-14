<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 014 14/08/2023
  Time: 04:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home/index" method="post">
    <input type="text" placeholder="enter money" name="input">
    <select name="select1">
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    <select name="select2">
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    <input type="submit" value="Converter">
</form>
<p>Result: ${result}</p>
</body>
</html>
