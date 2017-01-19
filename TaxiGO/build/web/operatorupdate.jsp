<%-- 
    Document   : operatorupdate
    Created on : Jan 5, 2017, 6:13:58 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operator Edit - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h2><b><font face="Trebuchet MS">You can update your prices below.</font></b></h2>
        <form method="POST" action="OperatorServlet">
            <font face="Trebuchet MS">
            Base fare:
            <input type="number" required name="number1"><br>
            Price per km: 
            <input type="number" required name="number2"><br>
            Weekend fee: 
            <input type="number" required name="number3"><br>
            <br>
            <input type="submit" value="Update" required name="function" style = "height:30px; width:70px; font-size: 16px"/>
        </form></center>
    </body>
</html>
