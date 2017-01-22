<%-- 
    Document   : adminlogin
    Created on : Jan 16, 2017, 2:40:31 PM
    Author     : Sara

    Login page for the admin. If the username or password is wrong, an error message is shown. 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration - Taxi GO</title>
    </head>
    
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Welcome, Administrator!</font></h1>
        <form method="POST" action="AdminLoginServlet"> 

            <h2><font face="Trebuchet MS"><b>Please enter your username and password to log in: </b></h2><br>
            <b>Username: </b><br>
            <input type="text" name="username" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <b>Password: </b><br>
            <input type="password" name="password" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <input type="submit" value="Log In" name="function" style = "height:30px; width:70px; font-size: 16px"/><br>
            <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </form></center>
</body>
</html>
