<%@page import="essentials.adminEssentials"%>
<%@include file="../../config.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthorized.jsp" %>
<%=adminEssentials.getPage("Add Company","Admin")%> 
<form name="company" id="company">
    <div class="container">
        <div class="tiles">
            <%=func.getLoader("../../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Company Name</label>
                        <input type="text" name="txtCompany" id="txtCompany" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Contact No</label>
                        <input type="text" name="txtContact" id="txtContact" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Company Username</label>
                        <input type="text" name="txtUsername" id="txtUsername" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Company Password</label>
                        <input type="password" name="txtPassword" id="txtPassword" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Account Status</label>
                        <select id="txtStatus">
                            <option value="0" class="select-option">--Select--</option>
                            <option value='1' class="select-option">Account Activated</option>
                            <option value='2' class="select-option">Account Not Activated</option>
                            <option value='3' class="select-option">Account Blocked</option>
                            <option value='4' class="select-option">Temporary Locked</option>
                        </select>
                    </div>  
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label">Address</label>
                        <textarea class="form-control" name="txtAddress" id="txtAddress" style="resize: none;"></textarea>
                    </div>
                </div>
            <div class="row">
                <div class="column-4">
                    <div class="form-group">
                        <input type="submit" value="Save" id="btnSubmit" class="but but-pri"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<%=adminEssentials.footer()%>
