<%@page import="com.google.gson.Gson"%>
<%@include file="../../config.jsp" %>
<%
if (request.getMethod().equalsIgnoreCase("Post")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("SALARY"), userModel.class);
        um.setRequest(request);
        um.setResponse(response);
        cc.createSalary(um);
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
        <th>Salary Name</th>
        <th>Salary From</th>
        <th>Salary To</th>
        <th>Created By</th>
        <th>Leaves Allowed</th>
        <th>Action</th>
    </tr> 
    <%=cc.loadAllSalaries(um)%>        
</table>
<%
    }
%>