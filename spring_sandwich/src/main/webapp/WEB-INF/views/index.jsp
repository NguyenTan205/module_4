<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Chọn gia vị cho Sanwich:</h2>
<form action="${pageContext.request.contextPath}/save" method="post">
    <label>
        <input type="checkbox" name="condiment" value="Lettuce"> Lettuce <br>
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Tomato"> Tomato <br>
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Mustard"> Mustard <br>
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Sprouts"> Sprouts <br>
    </label>

    <button type="submit">Save</button>
</form>
</body>
</html>
