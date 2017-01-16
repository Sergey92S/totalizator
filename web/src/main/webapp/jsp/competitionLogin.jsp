<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 05.01.2017
  Time: 14:31
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

<div class="fields">

    <label><fmt:message key="greeting"/> ${name} ${surname}</label>
    <label><fmt:message key="info"/> ${balance}</label>

    <form name="logoutForm" method="POST" action="FrontController">
        <input type="hidden" name="command" value="logout"/>
        <div class="fields-criteria">
            <button name="logout" value="logout"><fmt:message key="logout"/></button>
        </div>
    </form>

</div>


<section id="page">

    <c:set var="perPage" scope="session" value="${2}"/>
    <c:set var="pageStart" value="${param.start}"/>

    <c:if test="${totalCount <= pageStart}">
        <c:set var="pageStart" value="${pageStart - perPage}"/>
    </c:if>

    <c:if test="${empty pageStart or pageStart < 0}">
        <c:set var="pageStart" value="0"/>
    </c:if>

    <a href="?command=logon&login=${login}&password=${password}&name=${name}&surname=${surname}&balance=${balance}&start=${pageStart - perPage}"><<</a>
    ${pageStart + 1} - ${pageStart + perPage}
    <a href="?command=logon&login=${login}&password=${password}&name=${name}&surname=${surname}&balance=${balance}&start=${pageStart + perPage}">>></a>

    <header>

        <hgroup>
            <h1><fmt:message key="deposit.h1"/></h1>
            <h3><fmt:message key="deposit.h3"/></h3>
        </hgroup>

        <nav class="bottom">

            <ul>
                <li><a href="?command=logon&login=${login}&password=${password}&name=${name}&surname=${surname}&balance=${balance}&start=${pageStart}&language=en" ><fmt:message key="deposit.language.en"/></a></li>
                <li><a href="?command=logon&login=${login}&password=${password}&name=${name}&surname=${surname}&balance=${balance}&start=${pageStart}&language=ru" }><fmt:message key="deposit.language.ru"/></a></li>
            </ul>

        </nav>

        <nav class="top">
            <ul>
                <c:forEach var="games" items="${result}" varStatus="loop" begin="${pageStart}" end="${pageStart + perPage - 1}">
                    <li><a href="#article${loop.index+1}"><fmt:message key="${games.key.getName()}"/></a></li>
                </c:forEach>
            </ul>
        </nav>

    </header>

    <section id="articles">
        <c:forEach var="games" items="${result}" varStatus="loop" begin="${pageStart}" end="${pageStart + perPage - 1}">

            <div class="line"></div>
            <article id="article${loop.index+1}">
                <h2 align="center"><fmt:message key="${games.key.getName()}"/></h2>
                <div class="line"></div>
                <ul class="events-list">
                    <c:forEach items="${games.value}" var="item">
                        <li>
                            <h2><a href="${item.getHref()}"><c:out value="${item.getName()}" /></a></h2>
                            <a href="${item.getHref()}" class="event-photo"><img src=<c:out value="${item.getImage()}" /> height="130" alt="world_cup_foot"/></a>
                            <p><c:out value="${item.getDescription()}" /></p>
                        </li>
                    </c:forEach>
                </ul>
            </article>
        </c:forEach>

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
