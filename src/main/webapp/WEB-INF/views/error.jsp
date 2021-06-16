<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.06.2021
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error occurred during your request - this page does not exist!</h1>
<p>Error code is "<%=response.getStatus() %>"</p>
<p>Error message is "<%=exception.getMessage() %>"</p>
<p>Error stack trace is "<%=exception.getStackTrace() %>"</p>
<button class="btn btn-primary" onclick="history.back()">Back to previous page</button>
</body>
</html>
