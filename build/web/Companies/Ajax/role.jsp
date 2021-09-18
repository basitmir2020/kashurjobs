<%@page import="com.google.gson.Gson"%>
<%@include file="../../config.jsp" %>
<%    if (request.getMethod().equalsIgnoreCase("POST")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("ROLE"), userModel.class);
        um.setRequest(request);
        um.setResponse(response);
        cc.saveRole(um);
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
        <th>Roll Name</th>
        <th>Action</th>
    </tr> 
    <%=cc.loadAllRole(um)%>            
</table>
<%
    }
%>
