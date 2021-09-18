<%@page import="controller.adminController"%>
<%@page import="model.userModel"%>
<%@page import="com.google.gson.Gson"%>
<%
    userModel um = new userModel();
    adminController ac = new adminController();
    if (request.getMethod().equalsIgnoreCase("POST")) {
        Gson json = new Gson();
        um = (userModel) json.fromJson(request.getParameter("DETAILS"), userModel.class);
        ac.Save(um);
        if (um.getMessage() == "success") {
            out.println("1");
        } else {
            out.println("<p class='alert alert-danger'>" + um.getMessage() + "</p>");
        }
    }else if(request.getMethod().equalsIgnoreCase("GET")){ 
        um.setSearch(request.getParameter("SEARCH"));
        um.setOrderBy(request.getParameter("SORT"));
        um.setLimit(request.getParameter("DISPLAY"));
%>
<table class="table table-striped">
    <tr>
      <th>S.No</th>
      <th>Company Name</th>
      <th>Company Username</th>
      <th>Phone No</th>
      <th>Status</th>
      <th>Action</th>
    </tr> 
    <%=ac.allCompanies(um)%>
</table>
<%
    }
%>