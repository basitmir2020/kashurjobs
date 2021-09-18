<%@include file="../../config.jsp"%>
<%  if (request.getMethod().equalsIgnoreCase("GET")) {
        um.setId(Integer.parseInt(request.getParameter("issue")));
        if (!request.getParameter("Taken").equals("")) {
            um.setSalaryTaken(request.getParameter("Taken"));
           System.out.println(request.getParameter("Taken")); 
        } else {
            System.out.println(request.getParameter("Taken"));
        }
        out.println(cc.issue(um));
    }
%>