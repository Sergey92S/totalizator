<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 09.01.2017
  Time: 13:54
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
    <form name="autorizationForm" method="POST" action="FrontController">
        <input type="hidden" name="command" value="autorization"/>
        <div class="fields-criteria">
            <label><fmt:message key="login"/></label>
            <input id="Login" name="login" type="text">
        </div>
        <div class="fields-criteria">
            <label><fmt:message key="password"/></label>
            <input id="Password" name="password" type="password">
        </div>
        <div class="fields-criteria">
            <button name="multisubmit" value="logon"><fmt:message key="logon"/></button>
            <button name="multisubmit" value="registration"><fmt:message key="registration"/></button>
        </div>

    </form>

    <div class="animation-arrow">
        <p>^</p>
    </div>

</div>

<section id="page">

    <header>
        <hgroup>
            <h1><fmt:message key="deposit.h1"/></h1>
            <h3><fmt:message key="deposit.h3"/></h3>
        </hgroup>

        <nav class="bottom">

            <ul>
                <li><a href="?command=deposit&start=${pageStart}&language=en" ><fmt:message key="deposit.language.en"/></a></li>
                <li><a href="?command=deposit&start=${pageStart}&language=ru" }><fmt:message key="deposit.language.ru"/></a></li>
            </ul>

        </nav>
    </header>

    <section id="articles">
        <article>
        <c:forEach var="match" items="${matchResult}">

            <table>
                <tr align="center">
                    <th>Event's name</th>
                    <th>Time</th>
                    <c:forEach var="winlevel" items="${match.getWinLevelList()}">
                        <th><c:out value="${winlevel.getBet()}" /></th>
                    </c:forEach>
                    <th>Result</th>
                </tr>
                <tr class="border_bottom" align="center">
                    <td align="left">
                        <c:forEach var="event" items="${match.getEventInfoList()}">
                            <c:out value="${event.getName()}" /> (<c:out value="${event.isHome()}" />)<br>
                        </c:forEach>
                    </td>
                    <td><c:out value="${match.getTime()}" /></td>
                    <c:forEach var="winlevel" items="${match.getWinLevelList()}">
                        <td><c:out value="${winlevel.getCoefficient()}" /></td>
                    </c:forEach>
                    <td><c:out value="${match.getResult()}" /></td>
                </tr>
            </table>

        </c:forEach>
        </article>
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
