<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 31.10.2016
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add movie</title>
</head>
<body>
<form method="POST" action="addMovie">
    <table align="center">
        <caption><strong>Add new movie:</strong></caption>
        <tr>
            <td>The name of movie:</td>
            <td><input  type="text" name="name" value="name"/></td>
        </tr>
        <tr>
            <td>Duration(sec):</td>
            <td><input type="number" name="duration" min="1" value="7200"/></td>
        </tr>
        <tr>
            <td>Release year:</td>
            <td><input type="number" name="year" min="1" value="2016"/></td>
        </tr>
        <tr>
            <td>DescriptionID:</td>
            <td><input type="number" name="descriptionId" min="1" /></td>
        </tr>
        <tr>
            <td>DirectorID:</td>
            <td><input type="number" name="directorId" min="1" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
