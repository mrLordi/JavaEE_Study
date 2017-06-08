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
    <title>Update description</title>
</head>
<body>
<form method="POST" action="updateDescription">
    <input type="hidden" name="id" value="<c:out value="${description.id}"/>" />
    <table align="center">
        <caption><strong>Update description:</strong></caption>
        <tr>
            <td>Title:</td>
            <td><input  type="text" name="title" value="<c:out value="${description.title}" />" /></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><input type="text" name="content" value="<c:out value="${description.content}" />" /></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
