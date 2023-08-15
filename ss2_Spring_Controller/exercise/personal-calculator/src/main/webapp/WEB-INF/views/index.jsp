<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 015 15/08/2023
  Time: 03:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/home/calculate" method="post">
    <input type="text" name="firstOperand" value="${first}">
    <input type="text" name="secondOperand" value="${second}">
    <br>
    <input type="submit" value="Addition(+)" name="calculate">
    <input type="submit" value="Subtraction(-)" name="calculate">
    <input type="submit" value="Multiplication(x)" name="calculate">
    <input type="submit" value="Division(/)" name="calculate">
</form>
<p>result: ${result}</p>
</body>
</html>
