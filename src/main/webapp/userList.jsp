<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/8/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">USERNAME</th>
        <th scope="col">PASSWORD</th>
        <th scope="col">LOCATION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${collegeList}" var="{college}">
        <tr>
            <td>${college.id}</td>
            <td>${college.userName}</td>
            <td>${college.password}</td>
            <td>${college.location}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
