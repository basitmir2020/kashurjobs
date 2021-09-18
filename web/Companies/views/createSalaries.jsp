<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Create Salaries", "Company",um)%>
<form action="" method="Post" id="user">
    <div class="conatiner">
    <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
        <%=func.getLoader("../")%>  
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Salary Name</label>
                    <input type="text" name="txtSalary" id="txtSalary" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Salary From</label>
                    <input type="text" name="txtFrom" id="txtFrom" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Salary To</label>
                    <input type="text" name="txtTo" id="txtTo" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Created By</label>
                     <select name="txtCreate" id="txtCreate" class="form-control">
                        <option value="0">--Created By--</option>
                        <%=cc.getAccounts(um)%>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">TA</label>
                    <input type="text" name="txtTa" id="txtTa" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">DA</label>
                    <input type="text" name="txtDa" id="txtDa" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">PF</label>
                    <input type="text" name="txtPf" id="txtPf" class="form-control"/>
                </div>
            </div>
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">OTHER</label>
                    <input type="text" name="txtOther" id="txtOther" class="form-control"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Day Deduction</label>
                     <input type="text"  name="txtDay" id="txtDay" class="form-control"/>
                    
                </div>
            </div>
             <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Minute Deduction</label>
                    <input type="text" required="true" name="txtMin" id="txtMin" class="form-control"/>

                    
                </div>
            </div>
        </div>
         <div class="row">
            <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Max Deduction Time</label>
                    <input type="text" required="true" name="txtTim" id="txtTim" class="form-control"/>

                    
                </div>
            </div>
             <div class="column-6">
                <div class="form-group">
                    <label class="control-label" style="color: #fff">Leaves Allowed</label>
                   <input type="text" name="txtLeaves" id="txtLeaves" class="form-control"/>
                   
                </div>
            </div>
        </div>
        <div class="row">
            <div class="column-offset-4 column-5">
                <div class="form-group">
                    <input type="submit" value="Create Salary" id="btnSalary" class="button button-pri"/>
                </div>  
            </div>
        </div>
    </div>
</div>
</form>
<%=companyEssentials.footer()%>