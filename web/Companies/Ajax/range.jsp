<%@include file="../../config.jsp"%>
<%  if (request.getMethod().equalsIgnoreCase("GET")) {
        um.setId(Integer.parseInt(request.getParameter("RANGE")));
        out.println(cc.range(um));
    }
%>
