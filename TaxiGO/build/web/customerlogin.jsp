<%-- 
    Document   : customerlogin
    Created on : Jan 14, 2017, 11:21:46 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Welcome Customer!</font></h1>
        <form action="CustomerLogIn" method="GET">
            <input type="text" placeholder="username" name="uname" style="height:25px; width:300px; font-size: 18px"/><br>
            <br>
            <input type="password" placeholder="password" name="pass" style="height:25px; width:300px; font-size: 18px" /><br>
            <br>
            <input type='submit' name="click" value="Log In" style = "height:30px; width:100px; font-size: 16px" /><br>
            <br>
            <input type='submit' name="click" value="Register" style = "height:30px; width:100px; font-size: 16px"/>
            <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b></form></center>
</body>
</html>
