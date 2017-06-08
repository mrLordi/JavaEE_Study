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
    <title>Update movie</title>
</head>
<body>
<form method="POST" action="updateMovie">
    <input type="hidden" name="id" value="<c:out value="${movie.movieId}"/>" />
    <table align="center">
        <caption><strong>Update movie:</strong></caption>
        <tr>
            <td>The name of movie:</td>
            <td><input  type="text" name="name" value="<c:out value="${movie.name}" />" /></td>
        </tr>
        <tr>
            <td>Duration(sec):</td>
            <td><input type="number" name="duration" value="<c:out value="${movie.duration}" />" min="1"/></td>
        </tr>
        <tr>
            <td>Release year:</td>
            <td><input type="number" name="year" value="<c:out value="${movie.year}" />" min="1"/></td>
        </tr>
        <tr>
            <td>DescriptionID:</td>
            <td><input type="number" name="descriptionId" value="<c:out value="${movie.description.descriptionId}" />" min="1"/></td>
        </tr>
        <tr>
            <td>DirectorID:</td>
            <td><input type="number" name="directorId" value="<c:out value="${movie.director.directorId}" />" min="1"/></td>
        </tr>
    </table>
    <div align="center">
        <input type="submit" value="Submit"/>
        <input type="button" value="Back" onclick="history.back()">
    </div>
</form>
</body>
</html>
