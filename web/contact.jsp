<%@page import="essentials.indexEssentials"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="config.jsp" %>
<%=indexEssentials.getPage()%>
<form method="POST" action="" id="ui">
    <table class="column-offset-5" id="contact">
        <h3 align="center">Contact Us</h3>
        <tr>
            <td>
                <%=func.getLoader("")%>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="Enter Name" name="txtName" id="txtName">
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="Enter Phone Number" name="txtContact" id="txtContact">
            </td>
        </tr>
        <tr>
            <td>
                <textarea placeholder="Enquiry About" name="txtEnquiry" id="txtEnquiry"></textarea>
            </td>
        </tr>
        <tr>
            <td>  
                <input type="submit" id="tblsubmit" value="Submit">
            </td>
        </tr>
    </table>
</form>

<%=indexEssentials.footer()%>
