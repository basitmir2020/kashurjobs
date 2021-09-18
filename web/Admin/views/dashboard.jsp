<%@page import="model.userModel"%>
<%@page import="controller.adminController"%>
<%@page import="essentials.adminEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthorized.jsp" %>
<%=adminEssentials.getPage("Dashboard","Admin")%>
<% userModel um = new userModel();%>
<div class="container">
    <div class="tiles">
        <div class="row">
            <div class="column-12">
                <div class="all-content">
                    <div class="hhh">
                        <div class="column-6"> 
                            <ul>
                                <li><img src="../img/svg/tags.svg" width="200" height="200"></li>
                                <li><h3>Enquiry</h3></li>
                                <li><p><%=adminController.getEnquiryRows(um)%><p></li>
                            </ul>      
                        </div>
                    </div>
                    <div class="hhh">
                        <div class="column-6">
                            <ul>
                                <li><img src="../img/svg/link.svg" width="200" height="200"></li>
                                <li><h3>Organization</h3></li>
                                <li><p><%=adminController.getCompanyRows(um)%><p></li>
                            </ul>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</div>
<%=adminEssentials.footer()%>
