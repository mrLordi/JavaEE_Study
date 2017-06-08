<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 12.10.2016
  Time: 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add description</title>
</head>
<body>
<form method="POST" action="addDescription">
    <table align="center">
        <caption><strong>Add new description:</strong></caption>
        <tr>
            <td>Title:</td>
            <td><input  type="text" name="title" /></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><input type="text" name="content" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
