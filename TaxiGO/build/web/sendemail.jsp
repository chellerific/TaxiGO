<%-- 
    Document   : sendemail
    Created on : Jan 14, 2017, 12:05:09 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administration - Taxi GO</title>
    </head>
    <body>
        <form action="AdminSendEmailServlet" method="POST">
            <b>You can send email to customers below.</b><br><br>
            Subject:<br>
            <input type="text" name="title" autofocus="true"><br>
            Message: <br>
            
            <textarea name="message" cols="100" rows="20">
                
            </textarea><br>
            <input type="submit" name="button" value="Send">
        </form>
    </body>
</html>
