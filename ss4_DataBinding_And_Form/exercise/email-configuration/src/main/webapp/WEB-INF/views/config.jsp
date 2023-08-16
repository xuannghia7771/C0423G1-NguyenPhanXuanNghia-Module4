<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 016 16/08/2023
  Time: 02:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="post" action="mailConfig">
    <table>
        <tr>
            <td>Language: </td>
            <td><form:select path="language">
                <form:option value="english">English</form:option>
                <form:option value="vietnamese">Vietnamese</form:option>
                <form:option value="japanese">Japanese</form:option>
                <form:option value="chinese">Chinese</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td>Page Size: </td>
            <td>Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
            </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spam Filter: </td>
            <td>
                <form:checkbox path="spam"></form:checkbox> Enable spam filter
            </td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td>
                <form:textarea path="signature"></form:textarea> emails per page
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
