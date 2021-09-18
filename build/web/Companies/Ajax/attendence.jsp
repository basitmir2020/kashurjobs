<%@page import="com.google.gson.Gson"%>
<%@include file="../../config.jsp" %>
<%    if (request.getMethod().equalsIgnoreCase("POST")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("ATTENDENCE"), userModel.class);
       um.setRequest(request);
       um.setResponse(response);
        cc.Attendence(um);
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
        <th>Employee</th>
        <th>Sch</th>
        <th>SignIn</th>
        <th>SignOut</th>
        <th>SignInDelay</th>
        <th>SignOutDelay</th>
        <th>OverTime</th>
        <th>Action</th>
    </tr> 
    <%=cc.loadAllAttendence(um)%>       
</table>
<%
    }
%>
