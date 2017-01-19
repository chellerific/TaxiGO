<%-- 
    Document   : taxioperatorlist
    Created on : Jan 14, 2017, 7:18:50 PM
    Author     : Chelsi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="service.Taxioperator"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
    <center><h1><font face="Trebuchet MS">List of Taxi Operators</h1>

        <form action="ConfirmTaxi" method="POST">
            <table border="2">
                <tr>
                    <td>Operator</td>
                    <td>Base Rate</td>
                    <td>Price Per Kilometer</td>
                    <td>Weekend Fee</td>
                    <td>Rating</td>
                    <td>Total Price (SEK)</td>
                </tr>
                <%
                    Taxioperator taxi = (Taxioperator) request.getAttribute("price0");
                    List<Double> priceArr = (List<Double>) request.getAttribute("priceArr");

                    int index = 0;

                    if (taxi != null) {
                        while (taxi != null) {


                %>
                <tr>
                    <td><%=taxi.getOperator()%></td>
                    <td><%=taxi.getBaserate()%></td>
                    <td><%=taxi.getPriceperkm()%></td>
                    <td><%=taxi.getWeekendfee()%></td>
                    <td><%=taxi.getRating()%></td>
                    <td> <%=priceArr.get(index)%> </td>
                    <td><input type="checkbox" name="chosen"value= "<%=taxi.getOperator() + " " + priceArr.get(index) %>"> </td>
                </tr>
                <%
                            
                            index = index + 1;
                            taxi = (Taxioperator) request.getAttribute("price" + index);
                        }
                    }
                %>


            </table>
            <br>
            <input type='submit' name="click" value="Confirm Booking Plan" style = "height:30px; width:70px; font-size: 16px"/>
            <input type="text" name="date" placeholder="YYYY-MM-DD"/>
            <input type="text" name="time" placeholder="HH:MM"/>
        </form>
    </body>
</html>
