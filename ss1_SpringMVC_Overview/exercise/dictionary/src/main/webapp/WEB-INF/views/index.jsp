<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 014 14/08/2023
  Time: 05:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="/home/index" method="post">
  <input type="text" name="input" placeholder="enter word">
  <input type="submit" value="translate">
</form>
<p>${result}</p>
</body>
</html>
