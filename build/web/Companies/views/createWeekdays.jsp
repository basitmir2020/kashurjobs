<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Create Weekdays", "Company",um)%>
<form action="" method="Post" id="Week">
    <div class="conatiner">
    <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
        <%=func.getLoader("../")%>  
     <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Create Weekdays</label>
                    <input type="text" name="txtWeek" id="txtWeek" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Created By</label>
                     <select name="txtCre" id="txtCre" class="form-control">
                        <option value="0">--Created By--</option>
                        <%=cc.getWeek(um)%>
                    </select>
                </div>
            </div>
        </div>
            <div class="row">
            <div class="column-5">
                <div class="form-group">
                    <input type="submit" value="Create Weekdays" id="btnWeekdays" class="button button-pri"/>
                </div>  
            </div>
        </div>
    </div>
</div>
</form>
<%=companyEssentials.footer()%>
