<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Dictionary Anh - Việt</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">

<h2>Tra cứu từ điển Anh - Việt</h2>

<form action="${pageContext.request.contextPath}/search" method="post" class="mt-3">
    <input type="text" name="word" placeholder="Nhập từ tiếng Anh..." class="form-control w-50 d-inline"/>
    <button type="submit" class="btn btn-primary">Search</button>
</form>

<div class="mt-3">
    <c:if test="${not empty result}">
        <p><b>${word}</b> → ${result}</p>
    </c:if>

    <c:if test="${not empty message}">
        <p class="text-danger">${message}</p>
    </c:if>
</div>

</body>
</html>
