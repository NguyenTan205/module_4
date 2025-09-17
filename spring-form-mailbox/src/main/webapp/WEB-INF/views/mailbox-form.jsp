<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mailbox Configuration</title>
    <link rel="stylesheet" th:href="@{/webjars/bootstrap/5.3.3/css/bootstrap.min.css}"/>
</head>
<body class="container py-5">

<h3 class="mb-4">Mailbox Settings</h3>

<form th:action="@{/mailbox}" th:object="${mailbox}" method="post" class="row g-3">

    <!-- Language -->
    <div class="col-md-6">
        <label class="form-label">Languages</label>
        <select class="form-select" th:field="*{languages}">
            <option th:each="lang : ${languages}"
                    th:value="${lang}"
                    th:text="${lang}"></option>
        </select>
    </div>

    <!-- Page Size -->
    <div class="col-md-6">
        <label class="form-label">Page Size</label>
        <select class="form-select" th:field="*{pageSize}">
            <option th:each="size : ${pageSize}"
                    th:value="${size}"
                    th:text="${size}"></option>
        </select>
    </div>

    <!-- Spam Filter -->
    <div class="col-md-12">
        <div class="form-check">
            <input type="checkbox" class="form-check-input" th:field="*{spamFilter}">
            <label class="form-check-label">Enable spam filter</label>
        </div>
    </div>

    <!-- Signature -->
    <div class="col-md-12">
        <label class="form-label">Signature</label>
        <textarea class="form-control" th:field="*{signature}" rows="4"></textarea>
    </div>

    <!-- Submit -->
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Save</button>
    </div>

</form>

</body>
</html>
