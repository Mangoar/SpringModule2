<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tag Gift Certificates</title>
</head>
<body>
<div align="center">
    <h1>Tag Gift Certificates</h1>
    <h3><a href="/epam_java_module2_war_exploded/">Home</a></h3>
    <h3><a href="/epam_java_module2_war_exploded/tags">Tags</a></h3>
    <h3><a href="/epam_java_module2_war_exploded/certificates">Certificates</a></h3>
    <table border="1">
        <th>Tag Name</th>
        <th>Cert Name</th>
        <th>Price</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Create Date</th>
        <th>Last Update Date</th>
        <c:forEach var="tagGiftCert" items="${listTagGiftCert}">
            <tr>
                <td>${tagGiftCert.name}</td>
                <td>${tagGiftCert.certName}</td>
                <td>${tagGiftCert.price}</td>
                <td>${tagGiftCert.duration}</td>
                <td>${tagGiftCert.description}</td>
                <td>${tagGiftCert.createDate}</td>
                <td>${tagGiftCert.lastUpdateDate}</td>

            </tr>
        </c:forEach>
    </table>
    <br>
    <form:form action="search_tag_gift_cert" method="get">
        <table>
            <tr>
                <td><label>Tag Name:</label></td>
                <td><input type="text" name="tagName"/></td>
            </tr>
            <tr>
                <td><label>Column for LIKE:</label></td>
                <td><select name="likeType">
                    <option value="default" label="Choose one"/>
                    <option value="cert_name" label="Cert Name"/>
                    <option value="description" label="Description"/>
                </select></td>

            </tr>
            <tr>
                <td><label>LIKE:</label></td>
                <td><input type="text" name="likeString"/></td>
            </tr>
            <tr>
                <td><label>Column for ORDER BY:</label></td>
                <td><select name="orderCol">
                    <option value="default" label="Choose one"/>
                    <option value="cert_name" label="Cert Name"/>
                    <option value="create_date" label="Create Date"/>
                </select></td>
            </tr>
            <tr>
                <td><label>ASC/DESC:</label></td>
                <td><select name="orderType">
                    <option value="asc" label="ASC"/>
                    <option value="desc" label="DESC"/>
                </select></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Search"></td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>