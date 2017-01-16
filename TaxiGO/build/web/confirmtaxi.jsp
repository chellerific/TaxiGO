<%-- 
    Document   : taxioperatorlist
    Created on : Jan 14, 2017, 7:18:50 PM
    Author     : Chelsi
--%>

<%@page import="service.Taxioperator"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
    </head>
    <body>
        <h1>List of Taxi Operators</h1>
        <table border="2">
            <tr>
                <td>Operator</td>
                <td>Base Rate</td>
                <td>Price Per Kilometer</td>
                <td>Weekend Fee</td>
                <td>Rating</td>
            </tr>
            <%
                Taxioperator taxi = (Taxioperator) request.getAttribute("price0");
                int index = 0;

                if (taxi != null) {
                    while (taxi != null) {
                        index = index + 1;


            %>
            <tr>
                <td><%=taxi.getOperator()%></td>
                <td><%=taxi.getBaserate()%></td>
                <td><%=taxi.getPriceperkm()%></td>
                <td><%=taxi.getWeekendfee()%></td>
                <td><%=taxi.getRating()%></td>
                <td><%=Double.parseDouble(request.getSession().getAttribute("dist").toString()) * taxi.getBaserate() * taxi.getPriceperkm()%></td>
                <td><input type="checkbox" name="chosen" value= "<%=taxi.getOperator()%>" </td>
            </tr>
            <%
                        taxi = (Taxioperator) request.getAttribute("price" + index);
                    }
                }
            %>


        </table>
        <form action="ConfirmTaxi" method="POST">
            <input type='submit' name="click" value="Confirm Booking" />
        </form>
    </body>
</html>
