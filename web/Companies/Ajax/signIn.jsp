<%@include file="../../config.jsp"%>
<%  if (request.getMethod().equalsIgnoreCase("GET")) {
        um.setId(Integer.parseInt(request.getParameter("SigInDelay")));
        out.println(cc.SignInDelay(um));
    }
%>
