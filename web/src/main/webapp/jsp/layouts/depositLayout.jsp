<%--
  Created by IntelliJ IDEA.
  User: Revotech
  Date: 23.11.2016
  Time: 14:12
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
    <title>Deposit</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <div id="header">
        <tiles:insertAttribute name="header" />
    </div>
    <div id="nav">
        <tiles:insertAttribute name="nav" />
    </div>
    <div id="content">

        <form onsubmit="return checkForm(this)" name="parserForm" method="POST" action="FrontController" enctype="multipart/form-data">
            <input type="hidden" name="command" value="parser"/>

            <table>
                <tr>
                    <td><fmt:message key="deposit.label.parser"/>:</td>
                    <td>
                        <select id="parser">
                            <option>DOM</option>
                            <option>SAX</option>
                            <option>StAX</option>
                        </select>
                    </td>
                    <td id='err_parser' class='error'><span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial"></font></span></td>
                </tr>
                <tr>
                    <td><fmt:message key="deposit.label.xmlFile"/>:</td>
                    <td><input id="xml" type="file" accept=".xml" name="file" size="60" /></td>
                    <td id='err_xml' class='error'><span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial"></font></span></td>
                </tr>
                <tr>
                    <td><fmt:message key="deposit.label.xsdFile"/>:</td>
                    <td>
                        <div class="input_button_style">
                            <div class="input_font_style"><fmt:message key="deposit.button.xsdFile"/></div>
                            <input id="xsd" type="file" accept=".xsd" name="file" size="60" class="input_input_style" onchange="loadFile(event)" />
                        </div>
                        <script>
                            var loadFile = function (event) {
                                var output = document.getElementById('output');
                                output.src = URL.createObjectURL(event.target.files[0]);
                            };
                        </script>
                    </td>

                    <td id='err_xsd' class='error'><span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial"></font></span></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Start"/></td>
                </tr>
            </table>

        </form>

        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#file').change(function() {
                    $('#file').each(function() {
                        var name = this.value;
                        reWin = /.*\\(.*)/;
                        var fileTitle = name.replace(reWin, "$1");
                        reUnix = /.*\/(.*)/;
                        fileTitle = fileTitle.replace(reUnix, "$1");
                        $('#namefile').html(fileTitle);
                    });
                });
            });
        </script>

        <script type="text/javascript">

            function checkForm(form){

                if (document.getElementById('parser').value==""){
                    document.getElementById('err_parser').innerHTML='Parser is requared';
                    document.getElementById('err_parser').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_parser').innerHTML="";
                };
                if (document.getElementById('xml').value==""){
                    document.getElementById('err_xml').innerHTML=<fmt:message key="deposit.label.xmlFileError"/>;
                    document.getElementById('err_xml').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_xml').innerHTML="";
                };
                if (document.getElementById('xsd').value==""){
                    document.getElementById('err_xsd').innerHTML='XSD File is requared';
                    document.getElementById('err_xsd').style.color = 'red';
                    return false;
                }
                else {
                    document.getElementById('err_xsd').innerHTML="";
                };
                return true;
            };
        </script>

        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${deleteSuccessMessage}</font></span>
        <br/> <span style="font-weight:bold"><font size="3" color="#FF0000" face="Arial">${errorValidationMessage}</font></span>

    </div>
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
</div>
</body>
</html>