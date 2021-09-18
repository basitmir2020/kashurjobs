<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Create Schedule", "Company", um)%>
<form action="" method="Post" id="schedule">
    <div class="conatiner">
        <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
            <%=func.getLoader("../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Schedule Name</label>
                        <input type="text" name="txtSchName" id="txtSchName" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Schedule From</label>
                        <input type="text" name="txtSchFrom" id="txtSchFrom" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Schedule To</label>
                        <input type="text" name="txtSchTo" id="txtSchTo" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Weekdays</label>
                        <select id="txtWeek" name="txtWeek" class="form-control">
                            <option value="0">--Select Weekdays--</option>
                            <%=cc.getweekDays(um)%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Sign In</label>
                        <input type="text" name="txtSignIn" id="txtSignIn" placeholder='hrs:mins' required='true' class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Sign Out</label>
                        <input type="text" name="txtSignOut" id="txtSignOut"  placeholder='hrs:mins'  required='true'  class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Created By</label>
                        <select id="txtCreate" name="txtCreate" class="form-control">
                            <option value="0">--Select Created By--</option>
                            <%=cc.getWeek(um)%>
                        </select>
                    </div>
                </div>
                <div class="column-5">
                    <div class="form-group">
                        <input type="submit" value="Create Schedule" id="btnSchedule" class="button button-pri"/>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</form>
<%=companyEssentials.footer()%>
