<%-- 
    Document   : newjsp
    Created on : Jan 11, 2017, 5:23:41 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
    </head>
    <body>
        <b>Here are lists of users:</b><br><br>
        <b>The users:</b><br>
        //TODO TABLE <br><br>

        <b>The taxi operators:</b><br>
        //TODO TABLE <br>
        <form method="POST" action=adminaddoperator.jsp> 
            <input type="submit" value="Add operator" name="function" />
        </form><br>
        
        <b>Send e-mail to registered users: </b><br>
        <form method="POST" action=sendemail.jsp> 
            <input type="submit" value="Send e-mail" name="function" />
        </form><br>
    </body>
</html>
