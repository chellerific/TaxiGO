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
    <body><center>
        <br>
        <br>
        <br>
        <form action="AdminSendEmailServlet" method="POST">
            <h2><font face="Trebuchet MS"><b>You can send email to customers below.</b></h2><br><br>
            <b>Subject:</b><br>
            <input type="text" name="title" autofocus="true" style = "width: 500px"><br>
            <b>Message: </b><br>
            
            <textarea name="message" cols="100" rows="20">
                
            </textarea><br>
            <br>
            <input type="submit" name="button" value="Send">
        </form></center>
    </body>
</html>
