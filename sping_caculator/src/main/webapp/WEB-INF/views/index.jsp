<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Máy tính đơn giản</h2>
<form action="${pageContext.request.contextPath}/caculate" method="post">
    <input type="number" name="num1" required>
    <input type="number" name="num2" required><br><br>
    <button type="submit" name="operator" value="+">Cộng (+)</button>
    <button type="submit" name="operator" value="-">Trừ (-)</button>
    <button type="submit" name="operator" value="*">Nhân (*)</button>
    <button type="submit" name="operator" value="/">Chia (/)</button>
</form>
<c:if test="${not empty message}">
    <h3>${message}</h3>
</c:if>
</body>
</html>