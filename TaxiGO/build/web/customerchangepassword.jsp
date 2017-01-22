<%-- 
    Document   : CustomerChangePassword
    Created on : Jan 20, 2017, 3:00:38 PM
    Author     : Sara

    The page where a customer can change their password. This page is sent to user via e-mail.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change password</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Forgotten password</font></h1>
        <form method="POST" action="ChangePasswordServlet"> 
            <h2><font face="Trebuchet MS"><b>Please enter your username and the new password: </b></h2><br>
            <b>Username: </b><br>
            <input type="text" name="username" required style="height:25px; width:300px; font-size: 18px"><br>
            <b>New password: </b><br>
            <input type="password" name="password" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <input type="submit" value="change" name="function" style = "height:30px; width:70px; font-size: 16px"/><br>
            <% String err = (String)request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </form></center>
    </body>
</html>
