 <%
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp?stat=101");
    if (session.getAttribute("COMPANYSESSION") == null) {
      rd.forward(request, response);
    }
%>
