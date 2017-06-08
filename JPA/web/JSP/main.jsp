<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win10
  Date: 30.10.2016
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <td>${movie.movieId}</td>
                <td><c:out value="${movie.name}" /></td>
                <td>${movie.duration}</td>
                <td>${movie.year}</td>
                <td>${movie.description.descriptionId}</td>
                <td>${movie.director.directorId}</td>
                <td>
                    <a href="deleteMovie?id=${movie.movieId}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateMovie?id=${movie.movieId}">
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
                <td>${description.descriptionId}</td>
                <td><c:out value="${description.title}"/></td>
                <td><c:out value="${description.content}"/></td>

                <td>
                    <a href="deleteDescription?id=${description.descriptionId}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateDescription?id=${description.descriptionId}">
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
            <td colspan="3">Actions</td>
        </tr>
        </thead>

        <c:forEach items="${requestScope.directors}" var="director">
            <tr align="center">
                <td>${director.directorId}</td>
                <td><c:out value="${director.name}"/></td>
                <td><c:out value="${director.surname}"/></td>

                <td>
                    <a href="deleteDirector?id=${director.directorId}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateDirector?id=${director.directorId}">
                        <img src="images/update.png" />
                    </a>
                </td>
                <td>
                    <a href="getAllMovies?id=${director.directorId}">getAllMovies</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center"><a href="addDirector"><img src="images/add.png" />Add new director</a></p>

    <hr/>
    <hr/>
    <table border="1" align="center">
        <caption><strong>Producers:</strong></caption>
        <thead>
        <tr align="center">
            <td>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Type</td>
            <td colspan="2">Actions</td>
        </tr>
        </thead>

        <c:forEach items="${requestScope.producers}" var="producer">
            <tr align="center">
                <td>${producer.producerId}</td>
                <td><c:out value="${producer.name}"/></td>
                <td><c:out value="${producer.surname}"/></td>
                <td><c:out value="${producer.type}"/></td>

                <td>
                    <a href="deleteProducer?id=${producer.producerId}">
                        <img src="images/delete.png" />
                    </a>
                </td>
                <td>
                    <a href="updateProducer?id=${producer.producerId}">
                        <img src="images/update.png" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p align="center"><a href="addProducer"><img src="images/add.png" />Add new producer</a></p>

    <hr/>
    <hr/>
    <table border="1" align="center">
        <caption><strong>Movie - Producer</strong></caption>
        <thead>
        <tr align="center">
            <td>MovieID</td>
            <td>ProducerID</td>
            <td>Act</td>
        </tr>
        </thead>

        <c:forEach items="${movies}" var="movie">
            <c:forEach items="${movie.producers}" var="producer">
                <tr align="center">
                    <td><c:out value="${movie.movieId}" /></td>
                    <td><c:out value="${producer.producerId}" /></td>

                    <td>
                        <a href="deleteMP?movieId=${movie.movieId}&producerId=${producer.producerId}">
                            <img src="images/delete.png" />
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
    <p align="center"><a href="addMP"><img src="images/add.png" />Add Movie - Producer</a></p>

</body>
</html>
