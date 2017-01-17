<%-- 
    Document   : chooseuser
    Created on : Jan 9, 2017, 5:38:40 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Taxi GO</title>
    </head>
    <body>
        <h1>Welcome to Taxi GO! Book your travel now.</h1>
        <h2>How would you like to log in?</h2>
        <form action="ChooseUser" method="POST">
            <input type='submit' name="click" value="Guest" />
            <input type='submit' name="click" value="Customer" />
            <input type='submit' name="click" value="TaxiOperator" />
            <input type='submit' name="click" value="Administrator" />
        </form>
    </body>
</html>
