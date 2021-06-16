<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.06.2021
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New/Edit Certificate</title>
</head>
<body>
<div align="center">
    <h3><a href="/epam_java_module2_war_exploded/certificates">Back to Certificates</a></h3>
    <h1>New/Edit Certificate</h1>
    <form:form action="save_certificate" method="post" modelAttribute="cert">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td><form:label path="certName">Certificate Name:</form:label></td>
                <td><form:input path="certName" /></td>
            </tr>
            <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td><form:label path="price">Price:</form:label></td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td><form:label path="duration">Duration:</form:label></td>
                <td><form:input path="duration" /></td>
            </tr>
            <tr>
                <td><label>Add tag:</label></td>
                <td><input type="text" name="newTag"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save Certificate"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
