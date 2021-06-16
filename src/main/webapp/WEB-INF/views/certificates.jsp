<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.06.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Certificates</title>
</head>
<body>
<div align="center">
    <h1>Certificates</h1>
    <h3><a href="/epam_java_module2_war_exploded/">Home</a></h3>
    <h3><a href="/epam_java_module2_war_exploded/tags">Tags</a></h3>
    <br>
    <h3><a href="/epam_java_module2_war_exploded/new_cert_form">New Certificate</a></h3>
    <table border="1">
        <th>Id</th>
        <th>Cert Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Create Date</th>
        <th>Duration</th>
        <th>Last_Update</th>
        <th>Action</th>
        <c:forEach var="certificate" items="${listCertificate}">
            <tr>
                <td>${certificate.id}</td>
                <td>${certificate.certName}</td>
                <td>${certificate.description}</td>
                <td>${certificate.price}</td>
                <td>${certificate.createDate}</td>
                <td>${certificate.duration}</td>
                <td>${certificate.lastUpdateDate}</td>
                <td>
                    <a href="edit_cert_form?id=${certificate.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete_certificate?id=${certificate.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
