<%-- 
    Document   : customermain
    Created on : Jan 14, 2017, 11:21:55 PM
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
    <br><center>
        <h1><font face="Trebuchet MS">Welcome, <%=request.getSession().getAttribute("booker")%>. Choose your travel.</font></h1>
        <% if (request.getSession().getAttribute("status").equals(true)) {%>
        <h2><font face="Trebuchet MS">Your account has been reported.<br>
            Please contact customer service at taxigo.project@gmail.com for more information.</font></h2><br>
            <font face="Trebuchet MS">
        <b>Customer service hotline: +46735466828 </b><br>
        <br>
        <b>Available Hours</b><br>
        10:00 - 18:00 (Weekdays)<br>
        10:00 - 16:00 (Weekends)</font><br>
        <% } else { %>
        <form action="Customer" method="GET">
            <input type="text" placeholder="Your location.." name="origin" required style="height:50px; width:500px; font-size: 18px"/><br>
            <br>
            <input type="text" placeholder="Your destination.." name="dest" required style="height:50px; width:500px; font-size: 18px"/><br>
            <br>
            <input type='submit' name="click" value="Book a Travel" style="height:50px; width:130px; font-size: 18px"/> 
        </form></center>
        <% } %>
    </body>
</html>
