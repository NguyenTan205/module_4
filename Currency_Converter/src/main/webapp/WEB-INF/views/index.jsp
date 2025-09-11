<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>USD -- VND Converter</h2>
<form action="convert" method="post">
    <label>Exchange rate</label>
    <input type="text" name="rate" required><br><br>

    <label>Amount in USD</label>
    <input type="text" name="usd" required><br><br>

    <button type="submit">Convert</button>
</form>
</body>
</html>
