<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 31.10.2016
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update producer</title>
</head>
<body>
<form method="POST" action="updateProducer">
    <input type="hidden" name="id" value="<c:out value="${producer.producerId}"/>" />
    <table align="center">
        <caption><strong>Update producer:</strong></caption>
        <tr>
            <td>Name:</td>
            <td><input  type="text" name="name" value="<c:out value="${producer.name}" />" /></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname" value="<c:out value="${producer.surname}" />" /></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><input type="text" name="type" value="<c:out value="${producer.type}" />" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
