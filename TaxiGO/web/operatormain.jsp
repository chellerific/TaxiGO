<%-- 
    Document   : operatormain
    Created on : Jan 5, 2017, 6:13:24 PM
    Author     : Sara
--%>

<%@page import="service.Taxioperator"%>
<%@page import="service.Bookings"%>
<%@page import="java.util.List"%>
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
         <center>
             <h2><font face="Trebuchet MS"><b>Bookings Done in Your Company</b></h2>
        
        <form method="POST" action="OperatorServlet">
            <table border="2">
            <tr>
                <td>Customer</td>
                <td>Origin</td>
                <td>Destination</td>
                <td>Price (SEK)</td>
                <td>Date</td>
                <td>Time</td>
                <td>Report</td>
                <td>Reported during this session</td>
            </tr>
            <%
                Bookings booking = (Bookings)request.getAttribute("data0");
                int index = 0;
                
                if (booking != null) {
                    while (booking != null) {
                    index = index + 1;
                    
            %>
            <tr>
            <td><%=booking.getCustomer() %></td>
            <td><%=booking.getOrigin() %></td>
            <td><%=booking.getDestination() %></td>
            <td><%=booking.getPrice()%></td>
            <td><%=booking.getDate() %></td>
            <td><%=booking.getTime() %></td>
            <td><input type="radio" name="chosen"value= "<%=booking.getCustomer()%>" required </td>
            <td><%=request.getSession().getAttribute("reported")%></td>
            </tr>
            <%
                
                    booking = (Bookings)request.getAttribute("data" + index);
                }
            }
            %>
        </table>
        <br>
        <input type="submit" value="Report" name="function">
        
        </form>
        <br>
        
        <br>
        <h2><b>Your Price Information</b></h2>
        <table border="2">
            <tr>
                <td>Base rate</td>
                <td>Price per km</td>
                <td>Weekend fee</td>
                <td>Rating</td>
            </tr>
            <% 
                Taxioperator taxi = (Taxioperator)request.getAttribute("price");
            %>
            <tr>
            <td><%=taxi.getBaserate()%></td>
            <td><%=taxi.getPriceperkm() %></td>
            <td><%=taxi.getWeekendfee() %></td>
            <td><%=taxi.getRating() %></td>
            </tr>

        </table>
            <br>
        <b>If you want to edit your price information, press the button below.</b>
        <form method="POST" action="operatorupdate.jsp"> 
            <input type="submit" value="Edit" name="function" />
        </form></center>
        
    </body>
</html>
