 <%@page import="config.configuration"%>
<%
 RequestDispatcher rd = request.getRequestDispatcher("../"+configuration.INDEXURL+"?stat=101");
 boolean cd = false;
        Cookie c[] = request.getCookies();
        if(c!=null){
        for (Cookie c1 : c) {
            if (c1.getName().equals("ADMINCOOKIE")) {
                cd = true;
            }
        }
        }
        if (request.getSession().getAttribute("ADMINSESSION") == null && cd == false) {
            rd.forward(request, response);
           //response.sendRedirect("../"+configuration.INDEXURL+"?stat=101");
        }
%>
