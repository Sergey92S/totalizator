<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 23.11.2016
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
Request from ${pageContext.errorData.requestURI} is failed
<br/> Servlet name or type: ${pageContext.errorData.servletName}
<br/> Status code: ${pageContext.errorData.statusCode}
<br/> Exception: ${pageContext.errorData.throwable}
</body>
</html>
