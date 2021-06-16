<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.06.2021
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tags</title>
</head>
<body>
<div align="center">
    <h1>Tags</h1>
    <h3><a href="/epam_java_module2_war_exploded/">Home</a></h3>
    <h3><a href="/epam_java_module2_war_exploded/certificates">Certificates</a></h3>
    <br>
    <h3><a href="/epam_java_module2_war_exploded/new_tag_form">New Tag</a></h3>
    <table border="1">
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
        <c:forEach var="tag" items="${listTag}">
            <tr>
                <td>${tag.id}</td>
                <td>${tag.name}</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete_tag?id=${tag.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
