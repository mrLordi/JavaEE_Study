<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 02.11.2016
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>director all movies</title>
</head>
<body>
<table border="1" align="center">
    <caption><strong>Movies:</strong></caption>
    <thead>
    <tr align="center">
        <td>ID</td>
        <td>Name</td>
        <td>Duration(sec)</td>
        <td>Year</td>
        <td>DescriptionID</td>
        <td>DirectorID</td>
    </tr>
    </thead>

    <c:forEach items="${requestScope.movies}" var="movie">
        <tr align="center">
            <td>${movie.movieId}</td>
            <td><c:out value="${movie.name}" /></td>
            <td>${movie.duration}</td>
            <td>${movie.year}</td>
            <td>${movie.description.descriptionId}</td>
            <td>${movie.director.directorId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
