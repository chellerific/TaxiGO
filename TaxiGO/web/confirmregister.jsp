<%-- 
    Document   : confirmregister
    Created on : Jan 16, 2017, 1:48:10 PM
    Author     : Chelsi

    Confirmation page for when a customer has successfully registered for our services
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration - Taxi GO</title>
    </head>
    <body><center>
        <br>
        <br>
        <br>
        <br>
        <br>
        <h1><font face="Trebuchet MS">Your registration is complete.</font></h1>
        <form action="customerlogin.jsp" method="GET">
            <input type='submit' name="click" value="Log In" style="height:50px; width:130px; font-size: 18px"/></form>
    </center></body>
</html>
