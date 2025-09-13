<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h2>Các gia vị bạn đã chọn:</h2>
<c:if test="${empty selectedCondiments}">
    <p>Không có gia vị nào được chọn</p>
</c:if>
<c:forEach var="item" items="${selectedCondiments}">
    <p>${item}</p>
</c:forEach>
<br>
<a href="/">Back</a>
</body>
</html>
