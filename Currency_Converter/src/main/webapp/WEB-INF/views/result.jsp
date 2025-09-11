<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Conversion Result</h2>
    <p>Exchange Rate: ${rate}</p>
    <p>USD: ${usd}</p>
    <p><b>VND: ${vnd}</b></p>

    <a href="<c:url value='/'/>">Back</a>
</body>
</html>
