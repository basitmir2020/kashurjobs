<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Create User", "Company", um)%>
<form action="" method="Post" id="user">
    <div class="conatiner">
    <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
        <%=func.getLoader("../")%>  
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">First Name</label>
                    <input type="text" name="txtFirst" id="txtFirst" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Last Name</label>
                    <input type="text" name="txtLast" id="txtLast" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Username</label>
                    <input type="text" name="txtUsername" id="txtUsername" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Password</label>
                    <input type="password" name="txtPassword" id="txtPassword" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Mobile 1</label>
                    <input type="text" name="txtmobile1" id="txtmobile1" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Mobile 2</label>
                    <input type="text" name="txtmobile2" id="txtmobile2" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Email</label>
                    <input type="text" name="txtEmail" id="txtEmail" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Address</label>
                    <input type="text" name="txtAddress" id="txtAddress" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Gender</label>
                    <select name="txtGender" id="txtGender" class="form-control">
                        <option value="0">--Select--</option>
                        <option value="1">Male</option>
                        <option value="2">Female</option>
                    </select>
                </div>
            </div>
            <div class="column-4">
                <div class="form-group">
                    <input type="submit" value="Save" id="btnSubmit" class="button button-pri"/>
                </div>  
            </div>
        </div>
    </div>
</div>
</form>
<%=companyEssentials.footer()%>
