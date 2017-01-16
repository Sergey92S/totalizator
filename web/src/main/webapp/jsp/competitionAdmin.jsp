<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 08.01.2017
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html lang="${language}">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title><fmt:message key="deposit.h1"/></title>

    <link rel="stylesheet" type="text/css" href="css/styles.css" />

</head>

<body>

<section id="page">


    </section>

    <footer>

        <div class="line"></div>

        <p><fmt:message key="copyright"/></p>

        <a href="#" class="up1"><fmt:message key="goup"/></a>
        <a href="#" class="up2"><fmt:message key="goup"/></a>

    </footer>

</section>

</body>
</html>