<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 11.10.2016
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
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
            <td colspan="2">Actions</td>
        </tr>
        </thead>

        <c:forEach items="${requestScope.movies}" var="movie">
            <tr align="center">
                <td>${movie.id}</td>
                <td><c:out value="${movie.name}" /></td>
                <td>${movie.duration}</td>
                <td>${movie.year}</td>
                <td>${movie.descriptionId}</td>
                <td>${movie.directorId}</td>
                <td>
                    <a href="deleteMovie?id=${movie.id}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateMovie?id=${movie.id}">
                        <img src="images/update.png" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p align="center"><a href="addMovie"><img src="images/add.png" />Add new movie</a></p>

    <hr/>
    <hr/>
    <table border="1" align="center">
        <caption><strong>Descriptions:</strong></caption>
        <thead>
        <tr align="center">
            <td>ID</td>
            <td>Title</td>
            <td>Content</td>
            <td colspan="2">Actions</td>
        </tr>
        </thead>

        <c:forEach items="${requestScope.descriptors}" var="description">
            <tr align="center">
                <td>${description.id}</td>
                <td><c:out value="${description.title}"/></td>
                <td><c:out value="${description.content}"/></td>

                <td>
                    <a href="deleteDescription?id=${description.id}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateDescription?id=${description.id}">
                        <img src="images/update.png" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center"><a href="addDescription"><img src="images/add.png" />Add new description</a></p>
    <hr/>
    <hr/>
    <table border="1" align="center">
        <caption><strong>Directors:</strong></caption>
        <thead>
        <tr align="center">
            <td>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td colspan="2">Actions</td>
        </tr>
        </thead>

        <c:forEach items="${requestScope.directors}" var="director">
            <tr align="center">
                <td>${director.id}</td>
                <td><c:out value="${director.name}"/></td>
                <td><c:out value="${director.surname}"/></td>

                <td>
                    <a href="deleteDirector?id=${director.id}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateDirector?id=${director.id}">
                        <img src="images/update.png" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center"><a href="addDirector"><img src="images/add.png" />Add new director</a></p>
</body>
</html>
