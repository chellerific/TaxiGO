<%-- 
    Document   : adminaddoperator
    Created on : Jan 11, 2017, 5:43:37 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Operator - Taxi GO</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
        <center><h2><b><font face="Trebuchet MS">You can add a new operator here:</font></b></h2>
        <form method="POST" action="AdminServlet">
            <font face="Trebuchet MS">
            Company name:
            <input type="text" name="number1"><br>
            <br>
            Base rate:
            <input type="number" name="number2"><br>
            <br>
            Price per km: 
            <input type="number" name="number3"><br>
            <br>
            Weekend fee: 
            <input type="number" name="number4"><br>
            <br>
            Rating: 
            <input type="number" name="number5"><br>
            <br>
            Email:
            <input type="email" name="number6"><br>
            <br>
            Phone:
            <input type="number" name="number7"><br>
            <br>
            Password:
            <input type="password" name="number8"><br>
            <br>
            
            <input type="submit" value="Update" name="function" style = "height:30px; width:70px; font-size: 16px" />
        </form> <br>
        <% String err = (String) request.getAttribute("error");
                if (err == null) {
                    err = "";
                }
            %>
            <b> <%=err%> </b>
        </center>
    </body>
</html>
