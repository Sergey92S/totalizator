<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 10.01.2017
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>

<html lang="${language}">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title><fmt:message key="deposit.h1"/></title>

    <link rel="stylesheet" type="text/css" href="css/styles.css"/>

</head>

<body>

<div class="fields">

    <label><fmt:message key="greeting"/> ${name} ${surname}</label>
    <label><fmt:message key="info"/> ${balance}</label>

    <form name="addMoneyForm" method="POST" action="FrontController">
        <input type="hidden" name="command" value="addMoney"/>
        <input type="text" name="adding" value=""/>
        <div class="fields-criteria">
            <button name="addMoney" value="addMoney">Add Money</button>
        </div>
    </form>

    <form name="logoutForm" method="POST" action="FrontController">
        <input type="hidden" name="command" value="logout"/>
        <div class="fields-criteria">
            <button name="logout" value="logout"><fmt:message key="logout"/></button>
        </div>
    </form>

</div>

<section id="page">

    <header>
        <hgroup>
            <h1><fmt:message key="deposit.h1"/></h1>
            <h3><fmt:message key="deposit.h3"/></h3>
        </hgroup>

        <nav class="bottom">

            <ul>
                <li><a href="?command=rate&match=${match}&winLevel=${winlevel}&language=en"><fmt:message
                        key="deposit.language.en"/></a></li>
                <li><a href="?command=rate&match=${match}&winLevel=${winlevel}&language=ru" }><fmt:message
                        key="deposit.language.ru"/></a></li>
            </ul>

        </nav>
    </header>

    <section id="articles">
        <article>
            <ul class="history">
                <li>
                    <h2 align="center">Bet Slip</h2>
                    <form name="matchForm" method="POST"
                          action="FrontController">
                        <input type="hidden" name="command" value="bet"/>
                        <p>Match: <c:out value="${match.getName()}"/></p>
                        <p>Teams:
                            <c:forEach var="event" items="${match.getEventInfoList()}">
                                <c:out value="${event.getName()}"/> VS
                            </c:forEach>
                        </p>
                        <p>Time: <c:out value="${match.getTime()}"/></p>
                        <c:forEach var="win" items="${match.getWinLevelList()}">
                            <c:if test="${win.getId() eq winLevel}">
                                <p>Bet Type: <c:out value="${win.getBet()}"/></p>
                                <p>Coefficient: <c:out value="${win.getCoefficient()}"/></p>
                                <div class="fields">
                                    <input type="text" size="10" name="count" value=""/> * <c:out
                                            value="${win.getCoefficient()}"/>
                                    <button name="bet" value="bet">Make Rate</button>
                                </div>
                            </c:if>
                        </c:forEach>
                        <c:set var="match" value="${match.getId()}"/>
                    </form>
                </li>

                <li>
                    <h2 align="center">Bet History</h2>

                    <c:forEach var="rate" items="${rateResult}">

                        <table>
                            <tr align="center">
                                <th>Event's name</th>
                                <th>Time</th>
                                <th><c:out value="${rate.getBet()}" /></th>
                                <th>Result</th>
                                <th>Your Rate</th>
                            </tr>
                            <tr class="border_bottom" align="center">
                                <td align="left">
                                    <c:forEach var="event" items="${rate.getEventInfoList()}">
                                        <c:out value="${event.getName()}" /> (<c:out value="${event.isHome()}" />)<br>
                                    </c:forEach>
                                </td>
                                <td><c:out value="${rate.getTime()}" /></td>
                                <td><c:out value="${rate.getCoefficient()}" /></td>
                                <td><c:out value="${rate.getResult()}" /></td>
                                <td><c:out value="${rate.getAmount()}" /></td>
                            </tr>
                        </table>

                    </c:forEach>
                </li>



            </ul>



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