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
        <b>You can add a new operator here:</b>
        <form method="POST" action="AdminServlet">
            Company name:
            <input type="text" name="number1"><br>
            Base rate:
            <input type="number" name="number2"><br>
            Price per km: 
            <input type="number" name="number3"><br>
            Weekend fee: 
            <input type="number" name="number4"><br>
            Rating: 
            <input type="number" name="number5"><br>
            Email:
            <input type="text" name="number6"><br>
            Phone:
            <input type="text" name="number7"><br>
            Password:
            <input type="password" name="number8"><br>
            
            <input type="submit" value="Update" name="function" />
        </form>
    </body>
</html>
