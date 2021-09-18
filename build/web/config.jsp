<%@page import="controller.companyController"%>
<%@page import="model.userModel"%>
<%@page import="catalog.functions"%>
<%@page import="model.essentialModel"%>
<%
    userModel um = new userModel();
    um.setRequest(request);
    um.setResponse(response);
    functions func = new functions();
    companyController cc = new companyController();
 %>