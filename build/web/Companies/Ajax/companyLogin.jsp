<%@page import="controller.companyController"%>
<%@page import="model.userModel"%>
<%@page import="com.google.gson.Gson"%>

<%
userModel um = new userModel();
companyController cc = new companyController();
if(request.getMethod().equalsIgnoreCase("POST")){
  Gson json = new Gson();
  um = (userModel) json.fromJson(request.getParameter("LOGIN"), userModel.class);
  um.setRequest(request);
  um.setResponse(response);
  cc.Login(um);
  if (um.getMessage() == "success") {
            out.println("1");
        } else {
            out.println("<p class='alert alert-danger'>" + um.getMessage() + "</p>");
        }
}

%>
