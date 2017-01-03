<%-- 
    Document   : showinfo
    Created on : Jan 3, 2017, 1:41:00 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=request.getAttribute("name")%>
        <%=request.getAttribute("pass")%>
        <%=request.getAttribute("email")%>
        <%=request.getAttribute("nbr")%>
    </body>
</html>
