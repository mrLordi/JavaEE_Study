<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 12.10.2016
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update director</title>
</head>
<body>
<form method="POST" action="updateDirector">
    <input type="hidden" name="id" value="<c:out value="${director.id}"/>" />
    <table align="center">
        <caption><strong>Update director:</strong></caption>
        <tr>
            <td>Name:</td>
            <td><input  type="text" name="name" value="<c:out value="${director.name}" />" /></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname" value="<c:out value="${director.surname}" />" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
