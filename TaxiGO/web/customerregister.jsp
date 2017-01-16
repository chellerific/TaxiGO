<%-- 
    Document   : customerregister
    Created on : Jan 15, 2017, 7:54:58 PM
    Author     : Chelsi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taxi GO - Register</title>
    </head>
    <body>
        <h1>With a premium account, you can get some of Taxi GO's special offers.</h1>
        <form method="POST" action="CustomerRegister">
            Username:
            <input type="text" name="uname"><br>
            Password:
            <input type="password" name="pass"><br>
            Email: 
            <input type="text" name="email"><br>
            Phone: 
            <input type="text" name="phone"><br>
            
            <input type="submit" value="Register" name="click" />
        </form>
    </body>
</html>
