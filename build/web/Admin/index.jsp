<%@page import="essentials.securityEssentials"%>
<%@page import="config.configuration"%>
<%@page import="controller.adminController"%>
<%@page import="model.userModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            userModel um = new userModel();
            um.setRequest(request);
            um.setResponse(response);
            if (request.getMethod().equalsIgnoreCase("POST")) {
                um.setRemember(request.getParameter("txtCheck"));
                um.setUsername(request.getParameter("txtUsername"));
                um.setPassword(request.getParameter("txtPassword"));
                adminController ac = new adminController();
                ac.Login(um);
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link href="fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>   
        <!--===============================================================================================-->
        <link href="fonts/iconic/css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="../css/util.css">
        <link rel="stylesheet" type="text/css" href="../css/main.css">

        <!--===============================================================================================-->
        <title><%=configuration.TITLE%></title>
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('../img/bg-01.jpg');">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" method="POST" action="index.jsp">
                        <span class="login100-form-logo">
                            <i class="zmdi zmdi-landscape"></i>
                        </span>

                        <span class="login100-form-title p-b-34 p-t-27">
                            Log in
                        </span>
                        <span  style="color: white; background: red; text-align: center;">
                            <%= um.getMessage()%>
                            <%=securityEssentials.getMessage(
                                request.getParameter("stat") != null
                                ? request.getParameter("stat") : "", um)%>
                        </span>
                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <input class="input100" type="text" name="txtUsername" id="txtUsername" placeholder="Username">
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" name="txtPassword" id="txtPassword" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>

                        <div class="contact100-form-checkbox">
                            <input class="input-checkbox100" id="ckb1" type="checkbox" name="txtCheck" id="txtCheck">
                            <label class="label-checkbox100" for="ckb1">
                                Remember me
                            </label>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                        <div class="text-center p-t-90">
                            <a class="txt1" href="#">
                                Forgot Password?
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>