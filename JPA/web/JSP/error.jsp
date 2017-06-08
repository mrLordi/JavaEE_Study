<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 01.11.2016
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <div align="center">
        <h1>ERROR!</h1>
        <br />
        <br />
        <span style="font-weight: bold; font-size: 125%;">Cause: </span>${error}
        <br />
        <br />
        <input type="button" value="Back" onclick="history.back()">
    </div>
</body>
</html>
