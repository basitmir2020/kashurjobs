<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Add Attendence", "Company", um)%>
<form action="" method="Post" id="attendence">
    <div class="conatiner">
        <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
            <%=func.getLoader("../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Employee Name</label>
                        <select onchange="javaScript:SignInDelay()" id="txtEmp" name="txtEmp" class="form-control">
                            <option value="0">--Select Employee--</option>
                            <%=cc.AllEmployees(um)%>
                        </select>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Work Schedule</label>
                        <select id="txtSch" name="txtSch" class="form-control">
                            <option value="0">--Select Schedule--</option>
                            <%=cc.AllSchedule(um)%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row" id="hh">  
                
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">SignIn Delay</label>
                        <input type="text" placeholder="hrs:mm" name="txtSignInDelay" id="txtSignInDelay" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">SignOut Delay</label>
                        <input type="text" placeholder="hrs:mm" name="txtSignOutDelay" id="txtSignOutDelay" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">OverTime</label>
                        <input type="text" placeholder="hrs:mm" name="txtOverTime" id="txtOverTime" class="form-control"/>
                    </div>
                </div>
                <div class="column-5">
                    <div class="form-group">
                        <input type="submit" value="Add Attendence" id="btnAttendence" class="button button-pri"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%=companyEssentials.footer()%>
