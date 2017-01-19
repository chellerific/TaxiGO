<%-- 
    Document   : guestreceipt
    Created on : Jan 17, 2017, 10:22:26 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Complete - Taxi GO</title>
    </head>

    <body><center>
        <br>
        <br>
        <br>
        <% if (request.getSession().getAttribute("booker").equals("guest")) {%>
        <h1><font face="Trebuchet MS">Your travel plan has now been booked. </font></h1>
        <font face="Trebuchet MS">
        <b>Origin:</b> <%=request.getSession().getAttribute("origin")%>
        <b>Destination:</b> <%=request.getSession().getAttribute("dest")%>
        <b>Taxi Operator:</b> <%=request.getSession().getAttribute("operator")%>
        <b>Price:</b> <%=request.getSession().getAttribute("totalPrice")%> SEK<br>
        <br>
        Payment will be done through your desired operator's driver.</font>
        <br>
        <form action="chooseuser.jsp" method="GET">
            <input type='submit' name="click" value="Back to Homepage" style="height:50px; width:250px; font-size: 18px"/></form>
            <% } else {%>
            <h1><font face="Trebuchet MS">Your travel plan has now been booked, <%=request.getSession().getAttribute("booker")%></font></h1>
            <h2><font face="Trebuchet MS">A receipt has been sent to your email.</font></h2>
        <form action="chooseuser.jsp" method="GET">
            <input type='submit' name="click" value="Back to Homepage" style="height:50px; width:250px; font-size: 18px" /></form></center>
            <% }%>
    </body>
</html>
