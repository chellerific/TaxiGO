<%-- 
    Document   : operatorupdate
    Created on : Jan 5, 2017, 6:13:58 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operator Edit - Taxi GO</title>
    </head>
    <body>
        <b>You can update your prices below.</b>
        <form method="POST" action="OperatorServlet">
            Base fare:
            <input type="number" name="number1"><br>
            Price per km: 
            <input type="number" name="number2"><br>
            Weekend fee: 
            <input type="number" name="number3"><br>
            <input type="submit" value="Update" name="function" />
        </form>
    </body>
</html>
