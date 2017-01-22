<%-- 
    Document   : guestbooking
    Created on : Jan 9, 2017, 7:51:59 PM
    Author     : Chelsi

    The homepage for Guest where they can immediately choose a travel plan.
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Guest - Taxi GO</title>
    <body>
        <br>
        <br>
        <br>
        <br><center>
            <h1><font face="Trebuchet MS">Welcome Guest. Choose your travel.</font></h1>
            <form action="Guest" method="GET">
                <input type="text" placeholder="Your location.." name="origin" required style="height:50px; width:500px; font-size: 18px"/><br>
                <br>
                <input type="text" placeholder="Your destination.." name="dest" required style="height:50px; width:500px; font-size: 18px"/><br>
                <br>
                <input type='submit' name="click" value="Book a Travel" style="height:50px; width:130px; font-size: 18px"/> <br>
            </form></center>
    </body>
</head>
</html>
