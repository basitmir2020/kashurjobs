<%@page import="catalog.validation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String s = "password";
            out.println(s);
        %>
        <br/><br/><br/><br/><br/><br/><br/>
        <%
         s = validation.encryptSha512(validation.encryptMd5(validation.encryptSha512(validation.encryptMd5(s))));
         out.println(s);
         
        %>
    </body>
</html>
