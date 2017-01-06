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
        <title>Operator</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        <b>Bookings done in your company:</b>
        <table border="2">
            <tr>
                <td>Customer</td>
                <td>Origin</td>
                <td>Destination</td>
                <td>Price</td>
                <td>Booking ID</td>
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
            <td><%=booking.getBookingid() %></td>
            </tr>
            <%
                
                    booking = (Bookings)request.getAttribute("data" + index);
                }
            }
            %>
        </table>
        <br>
        <b>Your price information:</b>
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
        <b>If you want to edit your price information, press button below.</b>
        <form method="POST" action="operatorupdate.jsp"> 
            <input type="submit" value="Edit" name="function" />
        </form>
        
    </body>
</html>
