<%@page import="essentials.securityCompanies"%>
<%@page import="config.configuration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../config.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=configuration.TITLE%></title>
        <link href=<%="../" + configuration.STYLES%>companies.css rel="stylesheet" type="text/css"/>
        <script src=<%="../" + configuration.SCRIPTS%>jquery.min.js type="text/javascript"></script>
        <link href="../css/asserts/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    </head>
    <main class="conatiner">
        <div class="loginDiv">
            <div class="column-offset-3 column-6">
                <form action=""  method="POST">
                    <table cellpadding="5" cellspacing="5">
                        <tr>
                            <td class="topTD">
                                <h3>Company Login</h3>
                            </td>
                        </tr>
                        <tr>
                            <td><%= func.getLoader("../")%>
                                <%=securityCompanies.getMessage(
                                        request.getParameter("stat") != null
                                        ? request.getParameter("stat") : "", um)%></td>
                        </tr>
                        <tr>
                            <td><i class="fa fa-user"></i>
                                <input type="text" name="txtCompany" id="txtCompany" placeholder="Enter Username Here..." />
                            </td>
                        </tr>
                        <tr>
                            <td><i class="fa fa-lock"></i>
                                <input type="password" name="txtPass" id="txtPass" placeholder="Enter Password Here..." />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" name="btnLogin" id="btnLogin" value="Login" />
                            </td>
                        </tr>
                        <tr>
                            <td class="links" style='opacity:0.5'>
                                <a href="">forgot password?</a>
                                <a class="link" href="#">Click here</a>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </main>
    <script src="js/companyAccounts.js" type="text/javascript"></script>
</html>
