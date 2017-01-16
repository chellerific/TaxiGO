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
        <title>Taxi GO - Customer</title>
    </head>
    <body>
        <h1>Welcome. Choose your travel.</h1>
        <form action="Customer" method="GET">
            <input type="text" placeholder="Your location.." name="origin" />
            <input type="text" placeholder="Your destination.." name="dest" />
            <input type='submit' name="click" value="Book a Travel" /> 
        </form>
    </body>
</html>
