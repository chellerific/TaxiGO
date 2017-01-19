<%-- 
    Document   : customerregister
    Created on : Jan 15, 2017, 7:54:58 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">With a premium account, you can get some of Taxi GO's special offers.</font></h1>
        <form method="POST" action="CustomerRegister">
            <font face="Trebuchet MS"><b>Username:</b>
            <input type="text" name="uname" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <b>Password:</b>
            <input type="password" name="pass" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <b>Email:</b> 
            <input type="email" name="email" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <b>Phone:</b>
            <input type="number" name="phone" required style="height:25px; width:300px; font-size: 18px"><br>
            <br>
            <input type="submit" value="Register" name="click" required style = "height:30px; width:100px; font-size: 16px" />
        </form> <br>
        <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </center>
    </body>
</html>
