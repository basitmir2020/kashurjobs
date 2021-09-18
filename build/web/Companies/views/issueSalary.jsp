<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Issue Salary", "Company", um)%>
<form action="" method="Post" id="issuesalary">
    <div class="conatiner">
        <div class="tiles" style="background: url(../img/header.jpg); background-size: cover;  background-position: center; background-repeat: no-repeat;">
            <%=func.getLoader("../")%>  
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Employee Name</label>
                        <select onchange="javaScript:issue()"  id="txtEmp" name="txtEmp" class="form-control">
                            <option value="0">--Select Employee--</option>
                            <%=cc.AllEmployees(um)%>
                        </select>
                    </div>
                </div>
                <div class="column-6">
                    <div class="form-group">
                        <label class="control-label" style="color: #fff">Salary Taken</label>
                        <input onchange="javaScript:issue()" type="text" name="txtSalaryTaken" id="txtSalaryTaken" class="form-control"/>
                    </div>
                </div>      
            </div>
            <div id="all">
            </div>
            <div class="row">
                <div class="column-6">
                    <div class="form-group">
                        <input type="submit" value="Issue Salary" id="btnIssuesalary" class="button button-pri"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    $('#btnIssuesalary').click(function() {
        var issuesalary = {
            'id': $('#txtEmp').val(),
            'SalaryTo': $('#txtSalaryTaken').val(),
            'Balance': $('#txtBalance').val(),
            'Total': $('#txtTotalSalary').val(),
            'MaxDec': $('#txtTotalDec').val(),
            'Overtime': $('#overtime').val(),
            'MinDec': $('#txtminDec').val(),
            'DayDec': $('#txtdayDec').val(),
            'Leaves': $('#txtLeaves').val(),
            'salaryDate': $('#txtSalaryDate').val(),
            'SalaryTaken': $('#txtSalaryTakenDate').val()
        };
        $.ajax({
            url: "Ajax/issueSalary.jsp",
            type: "POST",
            data: {
                ISSUESALARY: JSON.stringify(issuesalary)
            },
            success: function(s) {
                s = $.trim(s);
                if (s === "1") {
                    $('#errorMsg').html("<p class='alert alert-success'>Salary Issued Successfully!</p>");
                } else {
                    $('#errorMsg').html(s);
                }
            }
        });
        return false;
    });
</script>
<%=companyEssentials.footer()%>