<%@page import="com.google.gson.Gson"%>
<%@include file="../../config.jsp" %>
<%    if (request.getMethod().equalsIgnoreCase("POST")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("EMPLOYEE"), userModel.class);
       um.setRequest(request);
       um.setResponse(response);
       cc.saveEmployee(um);
        if (um.getMessage() == "success") {
            out.println("1");
        } else {
            out.println("<p class='alert alert-danger'>" + um.getMessage() + "</p>");
        }
    }else if (request.getMethod().equalsIgnoreCase("Get")) {
        um.setSearch(request.getParameter("SEARCH"));
        um.setOrderBy(request.getParameter("SORT"));
        um.setLimit(request.getParameter("DISPLAY"));
%>
<table class="table table-striped">
    <tr>
        <th>S.No</th>
        <th>Name</th>
        <th>Sal-Range</th>
        <th>Salary</th>
        <th>Admit-on</th>
        <th>Relieve-on</th>
        <th>Emp-Time</th>
        <th>Sch</th>
        <th>Sal-Date</th>
        <th>Roll</th>
        <th>Action</th>
    </tr> 
    <%=cc.loadAllEmployees(um)%>          
</table>
<%
    }
%>
