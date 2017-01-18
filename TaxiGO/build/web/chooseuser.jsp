<%-- 
    Document   : chooseuser
    Created on : Jan 9, 2017, 5:38:40 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Taxi GO</title>
    </head>
    <body><br>
        <br>
        <br>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">Welcome to Taxi GO! Book your travel now.</h1>
        <h2>How would you like to log in?</h2>
        <form action="ChooseUser" method="POST">
            <input type='submit' name="click" value="Guest" style="height:50px; width:130px; font-size: 18px" />
            <input type='submit' name="click" value="Customer" style="height:50px; width:130px; font-size: 18px" />
            <input type='submit' name="click" value="Taxi Operator" style="height:50px; width:130px; font-size: 18px" />
            <input type='submit' name="click" value="Administrator" style="height:50px; width:130px; font-size: 18px" />

        </form></center>
</body>
</html>
