<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Update bai hat</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
  <style>
    div {
      margin-bottom: 1rem; /* 1rem = 16px */
    }
  </style>
</head>
<body>
<form:form method="post" modelAttribute="baihat" enctype="multipart/form-data" action="/baihat/edit">
  <form:hidden path="id" />
  <div class="mb-2">
    <label for="tenBaiHat">Ten bai hat:</label>
    <form:input path="tenBaiHat" cssClass="form-control" />
  </div>
  <div class="mb-2">
    <label for="ngheSi">Nghi si:</label>
    <form:input path="ngheSi" cssClass="form-control" />
  </div>
  <div class="mb-2">
    <label for="theLoai">The loai:</label>
    <form:input path="theLoai" cssClass="form-control" />
  </div>
  <div class="mb-2">
    <label for="file">File mp3:</label>
    <form:input type="file" path="file" cssClass="form-control" />
    <c:if test="${not empty baihat.fileBaiHat}">
      <audio src="/uploads/${baihat.fileBaiHat}" controls/>
    </c:if>
  </div>
  <button type="submit" class="btn btn-primary">Create bai hat</button>
  <a href="/baihat" class="btn btn-link">Quay lai</a>
</form:form>
</body>
</html>