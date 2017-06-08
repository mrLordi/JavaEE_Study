<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 31.10.2016
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Movie-Producer</title>
</head>
<body>
<form method="POST" action="addMP">
    <table align="center">
        <caption><strong>Add Movie-Producer:</strong></caption>
        <tr>
            <td>MovieID:</td>
            <td><input  type="number" name="movieId" min="1" /></td>
        </tr>
        <tr>
            <td>ProducerID:</td>
            <td><input type="number" name="producerId" min="1" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
