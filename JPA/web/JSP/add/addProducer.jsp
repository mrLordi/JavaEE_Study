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
    <title>Add producer</title>
</head>
<body>
<form method="POST" action="addProducer">
    <table align="center">
        <caption><strong>Add new producer:</strong></caption>
        <tr>
            <td>Name:</td>
            <td><input  type="text" name="name" value="name"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname" value="surname"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><input type="text" name="type" value="type"/></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
