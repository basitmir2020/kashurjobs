<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp"%>
<%=companyEssentials.getPage("Add Employee", "Company", um)%>
<form action="" method="Post" id="employee">
    <div class="conatiner">
        <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
            <%=func.getLoader("../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Employee Name</label>
                        <select id="txtEmp" name="txtEmp" class="form-control">
                            <option value="0">--Select Employee--</option>
                            <%=cc.getUser(um)%>
                        </select>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Salary Name</label>
                        <select onchange="javaScript:uuuuuu()" id="txtSalary" name="txtSalary" class="form-control">
                            <option value="0">--Select Salary--</option>
                            <%=cc.AllSalaries(um)%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div id="range"></div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Total Salary</label>
                        <input type="text" name="txtTotal" id="txtTotal" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Admitted On</label>
                        <input type="date" name="txtAdmitted" id="txtAdmitted" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Relieved On</label>
                        <input type="date" name="txtRelived" id="txtRelived" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Employee Time</label>
                        <input type="text" placeholder="hrs:mm" name="txtTime" id="txtTime" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Work Schedule</label>
                        <select id="txtSchedule" name="txtSchedule" class="form-control">
                            <option value="0">--Select Schedule--</option>
                            <%=cc.AllSchedule(um)%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Salary Date</label>
                        <input type="date" name="txtSalaryDate" id="txtSalaryDate" class="form-control"/>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Role</label>
                        <select id="txtRole" name="txtRole" class="form-control">
                            <option value="0">--Select Role--</option>
                            <%=cc.AllRole(um)%>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="column-5">
                    <div class="form-group">
                        <input type="submit" value="Add Employee" id="btnEmployee" class="button button-pri"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    function uuuuuu() {
        $.ajax({
            url: "Ajax/range.jsp",
            type: "GET",
            data: {
                RANGE: $('#txtSalary').val()
            },
            success: function(s) {
                s = $.trim(s);
                $('#range').html(s);
            },
            error: function(s) {
                alert(s);
            }
        });
    }
</script>
<%=companyEssentials.footer()%>
