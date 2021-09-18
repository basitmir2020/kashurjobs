<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%=companyEssentials.getPage("Manage User", "Company",um)%>
<div class="container">
    <div class="tiles">
        <div class="row">
            <div class="column-4">
                <div class="form-group">
                    <select name="txtLimit" id="txtLimit" class="form-company"
                            onchange="javascript:loadAllUsers();">
                        <option value="5">-- Load --</option>
                        <%
                            for (int i = 1; i <= 200; i++) {
                                i += 4;
                        %>
                        <option value="<%= i%>"><%= i%></option> 
                        <%
                            }
                        %>
                    </select>
                </div>
            </div>
            <div class="column-4">
                <div class="form-group">
                    <select name="txtOrder" id="txtOrder" class="form-company"
                            onchange="javascript:loadAllUsers();">
                        <option value="DESC">--Sort--</option>
                        <option value="ASC">Ascending </option>
                        <option value="DESC">Desending</option>
                    </select>
                </div>
            </div>
            <div class="column-4">
                <div class="form-group">
                    <input type="search" name="txtSearch" id="txtSearch" class="form-company" placeholder="Search..."
                           onkeyup="javascript:loadAllUsers();"/>
                </div>
            </div>
        </div> 
        <div class="row">
            <div class="column-12">
                <div class="table-responsive">
                    <div id="UsersList">
                        
                    </div>
                </div>
            </div>
        </div>            
    </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
       loadAllUsers(); 
});
</script>                       
<%=companyEssentials.footer()%>