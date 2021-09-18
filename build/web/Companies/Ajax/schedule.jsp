<%@page import="com.google.gson.Gson"%>
<%@include file="../../config.jsp" %>
<%    if (request.getMethod().equalsIgnoreCase("POST")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("SCHEDULE"), userModel.class);
        um.setRequest(request);
        um.setResponse(response);
        cc.workSchedule(um);
        if(um.getMessage()=="success"){
          out.println("1");
        }else{
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
        <th>Sch-From</th>
        <th>Sch-To</th>
        <th>Weekdays</th>
        <th>Sign-In</th>
        <th>Sign-Out</th>
         <th>Created-By</th>
        <th>Action</th>
    </tr> 
    <%=cc.loadAllWorkSchedule(um)%>            
</table>
<%
    }
%>