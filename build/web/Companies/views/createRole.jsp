<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Create Role", "Company", um)%>
<form method="Post" id="role">
    <div class="container">
        <div class="tiles"  style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
            <%=func.getLoader("../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Role</label>
                        <input type="text" name="txtrole" id="txtrole" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="column-4">
                        <input type="submit" value="Create Role" name="txtbtnrole" id="txtbtnrole" class="button button-pri" style="margin-bottom: 10px;"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%=companyEssentials.footer()%>
