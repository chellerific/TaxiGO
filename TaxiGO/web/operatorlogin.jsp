<%-- 
    Document   : start
    Created on : Jan 3, 2017, 3:44:42 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operator - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Welcome, Operator!</font></h1>
        <form method="POST" action="TaxiGoServlet"> 
            <h2><font face="Trebuchet MS"><b>Please enter your username and password to log in: </b></h2><br>
            <b>Username: </b><br>
            <input type="text" name="username" style="height:25px; width:300px; font-size: 18px"><br>
            <b>Password: </b><br>
            <input type="password" name="password" style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <input type="submit" value="Login" name="function" style = "height:30px; width:70px; font-size: 16px"/><br>
            <% String err = (String)request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </form></center>
    </body>
</html>
