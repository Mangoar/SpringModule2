<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.06.2021
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>New Tag</title>
</head>
<body>
<div align="center">
    <h1>New Tag</h1>
    <h3><a href="/epam_java_module2_war_exploded/tags">Back to Tags</a></h3>
    <form:form action="save_tag" method="post" modelAttribute="tag">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save Tag"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
