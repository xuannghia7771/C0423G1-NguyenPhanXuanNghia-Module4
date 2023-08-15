<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 015 15/08/2023
  Time: 03:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<br>
<form action="/home/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <input type="submit" value="save">
</form>
<p>${condiment}</p>
</body>
</html>
