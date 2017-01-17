<%-- 
    Document   : adminlogin
    Created on : Jan 16, 2017, 2:40:31 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration - Taxi GO</title>
    </head>
    <body>
        <h1>Welcome, Administrator!</h1>
        <form method="POST" action="AdminLoginServlet"> 
            <b>Please enter your username and password to log in: </b><br>
            Username: <br>
            <input type="text" name="username"><br>
            Password: <br>
            <input type="password" name="password"><br>
            <input type="submit" value="Login" name="function" /><br>
            <% String err = (String)request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </form>
    </body>
</html>
