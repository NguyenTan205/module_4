<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
  <meta charset="UTF-8">
  <title>Mailbox Configuration</title>
  <link rel="stylesheet" th:href="@{/webjars/bootstrap/5.3.3/css/bootstrap.min.css}"/>
</head>
<body class="container py-5">

<h3 class="mb-4">Current Mailbox Settings</h3>

<ul class="list-group">
  <li class="list-group-item">
    <strong>Language:</strong> <span th:text="${mailbox.languages}"></span>
  </li>
  <li class="list-group-item">
    <strong>Page Size:</strong> <span th:text="${mailbox.pageSize}"></span>
  </li>
  <li class="list-group-item">
    <strong>Spam Filter:</strong>
    <span th:text="${mailbox.spamFilter} ? 'Enabled' : 'Disabled'"></span>
  </li>
  <li class="list-group-item">
    <strong>Signature:</strong>
    <pre th:text="${mailbox.signature}" class="mb-0"></pre>
  </li>
</ul>

<div class="mt-4">
  <a th:href="@{/mailbox}" class="btn btn-secondary">Edit</a>
</div>

</body>
</html>
