<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 23.11.2016
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<table align="center" width="95%">
    <td>
        <span style="font-weight:bold">XML PARSERS</span>
    </td>
    <td><font size="5" color="white" face="Arial">_____________________________________________________________________________</font>
    </td>
    <td>
        <form>
            <table>
                <td>
                    <a href="?command=deposit&language=en" ${language == 'en' ? 'selected' : ''}>English</a>
                </td>
                <td>
                    <a href="?command=deposit&language=ru" ${language == 'ru' ? 'selected' : ''}>Russian</a>
                </td>
            </table>

        </form>
    </td>
</table>
