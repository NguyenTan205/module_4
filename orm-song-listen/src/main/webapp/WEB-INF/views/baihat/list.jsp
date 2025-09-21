<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách bai hat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Danh sách bai hat</h2>
    <a href="/baihat/create">Create</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Thể loại</th>
            <th>Nghệ sĩ</th>
            <th>File MP3</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="song" items="${list}">
            <tr>
                <td>${song.id}</td>
                <td>${song.tenBaiHat}</td>
                <td>${song.theLoai}</td>
                <td>${song.ngheSi}</td>
                <td>
                    <c:if test="${not empty song.fileBaiHat}">
                        <audio src="/uploads/${song.fileBaiHat}" controls/>
                    </c:if>
                </td>
                <td>
                    <a href="/baihat/edit/${song.id}" class="btn btn-primary btn-sm">Edit</a>
                    <a href="/baihat/delete/${song.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this song?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>