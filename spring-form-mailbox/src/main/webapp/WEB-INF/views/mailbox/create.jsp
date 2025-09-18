<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new mailbox</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="add-mailbox" modelAttribute="mailbox">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="pageSize">Page size: </form:label></td>
            <td>
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="spamsFilter">Spam Filter: </form:label></td>
            <td>
                <form:checkbox path="spamsFilter"/>
                Enable Spam Filter
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
